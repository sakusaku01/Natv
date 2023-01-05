package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.Request.ChannelRequest;
import kg.megacom.NaTv.models.Request.OrderRequest;
import kg.megacom.NaTv.models.dtos.*;
import kg.megacom.NaTv.models.entity.Discount;
import kg.megacom.NaTv.models.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.models.exceptions.ValueNotFoundExc;
import kg.megacom.NaTv.models.mappers.OrderDetailMapper;
import kg.megacom.NaTv.models.response.AnswerChannelResponse;
import kg.megacom.NaTv.models.response.AnswerResponse;
import kg.megacom.NaTv.models.status.Status;
import kg.megacom.NaTv.models.utils.ResourceBundle;
import kg.megacom.NaTv.models.utils.models.Language;
import kg.megacom.NaTv.repositories.ChannelRepository;
import kg.megacom.NaTv.repositories.DiscountRepository;
import kg.megacom.NaTv.repositories.OrderDetailRepository;
import kg.megacom.NaTv.services.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderDetailServicesImpl implements OrderDetailServices {

    private final OrderDetailRepository rep;
    private final OrderServices services;

    private final ChannelRepository channelRepository;

    private final ChannelServices channelServices;

    private final DaysServices daysServices;
    private final PricesServices pricesServices;
    private final DiscountRepository discountRepository;

    public OrderDetailServicesImpl(OrderDetailRepository rep, OrderServices services, ChannelRepository channelRepository, ChannelServices channelServices, DaysServices daysServices, PricesServices pricesServices, DiscountRepository discountRepository) {
        this.rep = rep;
        this.services = services;
        this.channelRepository = channelRepository;
        this.channelServices = channelServices;
        this.daysServices = daysServices;
        this.pricesServices = pricesServices;
        this.discountRepository = discountRepository;
    }


    @Override
    public OrderDetailDto save(OrderDetailDto orderDetailDto) {
        return OrderDetailMapper.INSTANCE.toDto(rep.save(OrderDetailMapper.INSTANCE.toEntity(orderDetailDto)));
    }

    @Override
    public OrderDetailDto findById(Long id,int lang) {
        Language language = Language.getLang(lang);
        return OrderDetailMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new EntityNotFoundExc(ResourceBundle.periodMessages(language,"orderDetailNotFound"))));
    }

    @Override
    public List<OrderDetailDto> findAll() {
        return OrderDetailMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED )
    public Map<String,List<BigDecimal>> countText(String text, List<ChannelRequest> requests) {

        BigDecimal totalPrice = BigDecimal.ZERO;
        List<BigDecimal> allPrices = new ArrayList<BigDecimal>();
        String str = text.replaceAll("\\s", "");
        for (int i = 0; i < requests.size(); i++) {

            PricesDto pricesDto = pricesServices.findByChannel(requests.get(i).getChannelId());

            int countOfDays = daysServices.countDays(requests.get(i).getDays());
            Long channelId = requests.get(i).getChannelId();

            Discount maxDaySale = discountRepository.findDiscountMinDays(countOfDays,channelId);
            if (maxDaySale==null) {
                BigDecimal nullPrice = pricesDto.getPrice().multiply(BigDecimal.valueOf(str.length()));
                BigDecimal allNulDaysPrice = nullPrice.multiply(BigDecimal.valueOf(countOfDays));
                allPrices.add(allNulDaysPrice);
                totalPrice = totalPrice.add(allNulDaysPrice);
                continue;
            }

            BigDecimal sale = pricesDto.getPrice().multiply(BigDecimal.valueOf(maxDaySale.getPercent()).divide(BigDecimal.valueOf(100)));
            BigDecimal salePrice = pricesDto.getPrice().subtract(sale);
            BigDecimal price = salePrice.multiply(BigDecimal.valueOf(str.length()));
            BigDecimal allDaysPrice = price.multiply(BigDecimal.valueOf(countOfDays));
            allPrices.add(allDaysPrice);
            totalPrice = totalPrice.add(allDaysPrice);

        }

        List<BigDecimal> all = Arrays.asList(totalPrice);
        Map<String,List<BigDecimal>> map =new HashMap<>();
        map.put("totalPrice",all);
        map.put("allPrices",allPrices);
        return map;
    }
    //1-количество дней
    //2-скидочные дни по количеству дней(3,5,7) и по дате
    //3-цена в зависимости от даты
    //4-рассчет стоимости за день
    //5-сумма всех дней
    //6-тотал-прайс



    @Override
    @Transactional(Transactional.TxType.REQUIRED )
    public AnswerResponse makeOrder(OrderRequest request,int lang) {
        channelChecker(request.getChannels(),lang);
//        priceChecker(request.getChannels(),lang);

        OrderDto dto = new OrderDto();
        dto.setName(request.getName());
        dto.setPhone(request.getPhone());
        dto.setEmail(request.getEmail());
        dto.setText(request.getText());
        dto.setStatus(Status.STRING);
        Map<String,List<BigDecimal>> pricesWithTotal = countText(request.getText(),request.getChannels());
        List<BigDecimal> totalPrice = pricesWithTotal.get("totalPrice");
        List<BigDecimal> allPrices = pricesWithTotal.get("allPrices");
        dto.setTotalPrice(totalPrice.get(0));
        dto.setAddDate(new Date());
        dto.setEditDate(new Date());

        dto=services.save(dto);

        for (int i = 0; i <request.getChannels().size() ; i++) {
            OrderDetailDto orderDetaildto = new OrderDetailDto();

            orderDetaildto.setPrice(allPrices.get(i));
            Long channelId = request.getChannels().get(i).getChannelId();
            orderDetaildto.setChannelId(channelServices.findById(channelId,lang));
            orderDetaildto.setOrderId(dto);
            save(orderDetaildto);
        }

        daysServices.stringParse(request.getChannels(),dto);

        List<AnswerChannelResponse> channelResponses = new ArrayList<>();

        for (int i = 0; i < request.getChannels().size(); i++) {
            AnswerChannelResponse channelResponse = new AnswerChannelResponse();
            ChannelDto channelDto = channelServices.findById(request.getChannels().get(i).getChannelId(),lang);
            channelResponse.setId(request.getChannels().get(i).getChannelId());
            channelResponse.setName(channelDto.getName());
            channelResponse.setPrices(allPrices.get(i));

            channelResponses.add(channelResponse);
        }
        AnswerResponse answerResponse =new AnswerResponse(dto.getTotalPrice(),channelResponses);

        return answerResponse;
    }


    @Override
    @Transactional(Transactional.TxType.REQUIRED )
    public void channelChecker(List<ChannelRequest> request,int lang){
        for (ChannelRequest channelRequest : request) {
            channelServices.findById(channelRequest.getChannelId(), lang);
        }
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED )
    public void priceChecker(List<ChannelRequest> request,int lang) {
        for (int i = 0; i < request.size(); i++) {
            pricesServices.finByPrice(request.get(i).getPrice(), lang);
        }
    }

}

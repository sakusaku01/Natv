package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.exceptions.ValueNotFoundExc;
import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.mappers.ChannelMapper;
import kg.megacom.NaTv.models.response.ChannelResponse;
import kg.megacom.NaTv.models.response.Response;

import kg.megacom.NaTv.models.status.MaxMin;
import kg.megacom.NaTv.utils.ResourceBundle;
import kg.megacom.NaTv.utils.models.Language;
import kg.megacom.NaTv.repositories.ChannelRepository;
import kg.megacom.NaTv.repositories.DiscountRepository;
import kg.megacom.NaTv.services.ChannelServices;
import kg.megacom.NaTv.microServices.FileServiceFeign;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class ChannelServicesImpl implements ChannelServices {

    private final ChannelRepository rep;

    private final DiscountRepository discountRepository;

    private final FileServiceFeign serviceFeign;

    public ChannelServicesImpl(ChannelRepository rep, DiscountRepository discountRepository, FileServiceFeign serviceFeign) {
        this.rep = rep;
        this.discountRepository = discountRepository;
        this.serviceFeign = serviceFeign;
    }


    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public List<?> findByAll(String name, BigDecimal price, Boolean isActive,
                             Boolean isDiscount, Boolean orderNum, MaxMin maxMin){
        int count = 0;

        StringBuilder sqlCode =
                new StringBuilder("select c from Channel c" +
                                  " inner join c.prices p inner join c.discounts d");

        if(name != null){

            if (count != 0) {
                sqlCode.append(" and");
                sqlCode.append(" where c.name LIKE ");
                sqlCode.append("'" + name + "%'");
            }else {
                sqlCode.append(" where c.name LIKE ");
                sqlCode.append("'" + name + "%'");
            }
            count++;

        }

        if(isActive !=null){
            if (count != 0) {
                sqlCode.append(" and");
                sqlCode.append(" where c.active = ");
                sqlCode.append(isActive);

            }else {
                sqlCode.append(" where c.active = ");
                sqlCode.append(isActive);
            }

            count++;
        }

        if(isDiscount !=null&& isDiscount){
            if (count != 0) {
                sqlCode.append(" and");
                sqlCode.append(" where d.minDays > 0");
            }else {
                sqlCode.append(" where d.minDays > 0");
            }

            count++;

        }
        if(isDiscount !=null && !isDiscount){
            if (count != 0) {
                sqlCode.append(" and");
                sqlCode.append(" where d is null");
            }else {
                sqlCode.append(" where d is null");
            }

            count++;

        }


        if (price != null){
            if (count != 0) {
                sqlCode.append(" and");
                sqlCode.append(" where p.price = ");
                sqlCode.append(price);
            }else {
                sqlCode.append(" where p.price = ");
                sqlCode.append(price);
            }

            count++;

        }
        if(orderNum !=null){

            sqlCode.append(" order by c.orderNum ASC");
            count++;

        }
        if (maxMin == MaxMin.MAX){

            sqlCode.append(" GROUP BY c.id order by MAX(p.price) DESC");
            count++;

        }
        if (maxMin == MaxMin.MIN){

            sqlCode.append(" GROUP BY c.id order by MIN(p.price) ASC");

            count++;
        }

        return entityManager.createQuery(sqlCode.toString()).getResultList();

    }


    @Override
    public ChannelDto save(ChannelDto channelDto,int lang) {
        return ChannelMapper.INSTANCE.toDto(rep.save(ChannelMapper.INSTANCE.toEntity(channelDto)));
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED )
    public String saveChannel(String name, MultipartFile multipartFile, int orderNum,Boolean isActive,int lang) {
        ChannelDto channelDto = new ChannelDto();
        channelDto.setName(name);
        channelDto.setActive(isActive);
        channelDto.setOrderNum(orderNum);
        channelDto.setPhoto(serviceFeign.storeFile(multipartFile).getDownloadUri());
        ChannelDto dto = save(channelDto,lang);
        return dto.getPhoto();

    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED )
    public ChannelDto findById(Long id,int lang) {
        Language language = Language.getLang(lang);
        return ChannelMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()-> new EntityNotFoundExc(ResourceBundle.periodMessages(language,"channelNotFound"))));
    }

    @Override
    public List<ChannelDto> findAll() {
        Language language = Language.getLang(1);
         if(ChannelMapper.INSTANCE.toDtos(rep.findAll()).isEmpty()){
             throw new ValueNotFoundExc(ResourceBundle.periodMessages(language,"channelsNotCreated"));
         }
         return ChannelMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public List<Response> channelsResponse(int page,int size) {

        List<Response> channelsResponse = rep.channelResponse(page, size);
        return channelsResponse;
    }

    @Override
    public List<ChannelResponse> channelsResponseDiscounts(int page, int size) {
        List<Response> list = channelsResponse(page,size);

        List<ChannelResponse> channelResponseList = new ArrayList<>();

        for (Response item:list) {
            ChannelResponse channelResponse = new ChannelResponse();
            channelResponse.setId(item.getId());
            channelResponse.setName(item.getName());
            channelResponse.setImage(item.getPhoto());
            channelResponse.setPrice(item.getPrice());

            channelResponse.setDiscountResponses(discountRepository.discountResponse(item.getId()));
            channelResponseList.add(channelResponse);



        }
        return channelResponseList;
    }


}

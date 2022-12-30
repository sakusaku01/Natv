package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.Request.ChannelRequest;
import kg.megacom.NaTv.models.Request.DayRequest;
import kg.megacom.NaTv.models.dtos.DaysDto;
import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.models.entity.Order;
import kg.megacom.NaTv.models.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.models.mappers.DaysMapper;
import kg.megacom.NaTv.models.utils.ResourceBundle;
import kg.megacom.NaTv.models.utils.models.Language;
import kg.megacom.NaTv.repositories.DaysRepository;
import kg.megacom.NaTv.repositories.OrderDetailRepository;
import kg.megacom.NaTv.services.DaysServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DaysServicesImpl implements DaysServices {

    private final DaysRepository rep;

    private final OrderDetailRepository orderDetailRepository;

    public DaysServicesImpl(DaysRepository rep, OrderDetailRepository orderDetailRepository) {
        this.rep = rep;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public DaysDto save(DaysDto daysDto) {
        return DaysMapper.INSTANCE.toDto(rep.save(DaysMapper.INSTANCE.toEntity(daysDto)));
    }

    @Override
    public DaysDto findById(Long id,int lang) {
        Language language = Language.getLang(lang);
        return DaysMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()-> new EntityNotFoundExc(ResourceBundle.periodMessages(language,"DaysNotFound"))));
    }

    @Override
    public List<DaysDto> findAll() {
        return DaysMapper.INSTANCE.toDtos(rep.findAll());
    }

//    @Override
//    public int stringParseOne(List<ChannelRequest> channelRequest){
//        return 1;
//    }

    @Override
    public int stringParse(List<ChannelRequest> channelRequest, OrderDto dto){

        if (channelRequest.size() == 0) {
            return 0;
        }
        int countDays = 0;
        for (int i = 0; i < channelRequest.size(); i++) {
            int length=channelRequest.get(i).getDays().get(0).getDay().length();
            String first = channelRequest.get(i).getDays().get(0).getDay();
            int count = 1;

            for (int f = 0; f < length - 1; f++){

                if ((first.charAt(f) == ' ') && (first.charAt(f + 1) != ' ')){

                    count++;
                }
            }

            countDays = count* channelRequest.get(i).getDays().size();
            DaysDto daysDto = new DaysDto();
            daysDto.setDay(countDays);
            daysDto.setOrderDetailId(orderDetailRepository.findOrderDetailByChannelId(channelRequest.get(i).getChannelId(),dto.getId()));
            save(daysDto);
        }


//        int length = days.get(0).length();
//        String first = days.get(0);

        return countDays;

    }
    @Override
    public int countDays(List<DayRequest> dayRequests){

        if (dayRequests.size() == 0) {
            return 0;
        }
        int countDays = 0;

        int length=dayRequests.get(0).getDay().length();
        String first = dayRequests.get(0).getDay();
        int count = 1;

        for (int f = 0; f < length - 1; f++){

            if ((first.charAt(f) == ' ') && (first.charAt(f + 1) != ' ')){

                count++;
            }
        }
        countDays = count* dayRequests.size();


        return countDays;

    }
}

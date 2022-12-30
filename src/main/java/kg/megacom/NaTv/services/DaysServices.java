package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.Request.ChannelRequest;
import kg.megacom.NaTv.models.Request.DayRequest;
import kg.megacom.NaTv.models.dtos.DaysDto;
import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.models.entity.Order;

import java.util.List;

public interface DaysServices extends BaseServices<DaysDto>{
//    int stringParseOne(List<ChannelRequest> channelRequest);


    int stringParse(List<ChannelRequest> channelRequest, OrderDto dto);

    int countDays(List<DayRequest> dayRequests);
}

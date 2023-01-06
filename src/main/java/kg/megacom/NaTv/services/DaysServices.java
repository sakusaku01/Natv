package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.Request.ChannelRequest;
import kg.megacom.NaTv.models.Request.DayRequest;
import kg.megacom.NaTv.models.dtos.DaysDto;
import kg.megacom.NaTv.models.dtos.OrderDto;

import java.util.List;

public interface DaysServices extends BaseServices<DaysDto>{

    int stringParse(List<ChannelRequest> channelRequest, OrderDto dto,int lang);

    int countDays(List<DayRequest> dayRequests);
}

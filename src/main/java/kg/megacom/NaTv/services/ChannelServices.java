package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.response.ChannelResponse;
import kg.megacom.NaTv.models.response.Response;

import java.util.List;

public interface ChannelServices extends BaseServices<ChannelDto>{
    List<Response> channelsResponse(int page,int size);

    List<ChannelResponse> channelsResponseDiscounts();
}

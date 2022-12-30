package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.response.ChannelResponse;
import kg.megacom.NaTv.models.response.Response;
import kg.megacom.NaTv.services.microServices.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChannelServices extends BaseServices<ChannelDto>{
    List<Response> channelsResponse(int page,int size);

    List<ChannelResponse> channelsResponseDiscounts(int page,int size);

    String saveChannel(String name, MultipartFile multipartFile, int orderNum);
}

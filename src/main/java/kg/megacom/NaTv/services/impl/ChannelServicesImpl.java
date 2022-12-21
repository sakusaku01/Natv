package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.mappers.ChannelMapper;
import kg.megacom.NaTv.models.response.ChannelResponse;
import kg.megacom.NaTv.models.response.Response;
import kg.megacom.NaTv.repositories.ChannelRepository;
import kg.megacom.NaTv.repositories.DiscountRepository;
import kg.megacom.NaTv.services.ChannelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChannelServicesImpl implements ChannelServices {

    private final ChannelRepository rep;

    private final DiscountRepository discountRepository;

    public ChannelServicesImpl(ChannelRepository rep, DiscountRepository discountRepository) {
        this.rep = rep;
        this.discountRepository = discountRepository;
    }

    @Override
    public ChannelDto save(ChannelDto channelDto) {
        return ChannelMapper.INSTANCE.toDto(rep.save(ChannelMapper.INSTANCE.toEntity(channelDto)));
    }

    @Override
    public ChannelDto findById(Long id) {
        return ChannelMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()-> new RuntimeException("Ошибка")));
    }

    @Override
    public List<ChannelDto> findAll() {
        return ChannelMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public List<Response> channelsResponse(int page,int size) {

        List<Response> channelsResponse = rep.channelResponse(page, size);
        return channelsResponse;
    }

    @Override
    public List<ChannelResponse> channelsResponseDiscounts() {
        List<Response> list = channelsResponse(0,100);

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

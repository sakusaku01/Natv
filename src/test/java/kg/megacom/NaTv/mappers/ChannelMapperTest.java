package kg.megacom.NaTv.mappers;

import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.entity.Channel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChannelMapperTest {


    ChannelMapper channelMapper = new ChannelMapperImpl();

    @Test
    void testChannelMapperToDto(){
        Channel channel = new Channel();
        channel.setId(1l);
        channel.setName("ktk");

        ChannelDto channelDto =channelMapper.toDto(channel);

        assertEquals(channelDto.getId(),1l);
        assertEquals(channelDto.getName(),"ktk");

    }

    @Test
    void testChannelMapperToEntity(){
        ChannelDto channelDto = new ChannelDto();
        channelDto.setId(1l);
        channelDto.setName("ntv");

        Channel channel =channelMapper.toEntity(channelDto);

        assertEquals(channel.getId(),1l);
        assertEquals(channel.getName(),"ntv");

    }

    @Test
    void testChannelMapperToDtos(){
        List<Channel> channel = new ArrayList<>();
        Channel channel1 = new Channel();
        channel1.setId(1l);
        channel1.setName("ktk");

        channel.add(channel1);

        List<ChannelDto> channelDto =channelMapper.toDtos(channel);

        assertEquals(channelDto.get(0).getId(),1l);
        assertEquals(channelDto.get(0).getName(),"ktk");

    }

    @Test
    void testChannelMapperToEntities(){
        List<ChannelDto> dtos = new ArrayList<>();
        ChannelDto channelDto = new ChannelDto();
        channelDto.setId(1l);
        channelDto.setName("ktk");

        dtos.add(channelDto);

        List<Channel> channel = channelMapper.toEntities(dtos);

        assertEquals(channel.get(0).getId(),1l);
        assertEquals(channel.get(0).getName(),"ktk");

    }



}
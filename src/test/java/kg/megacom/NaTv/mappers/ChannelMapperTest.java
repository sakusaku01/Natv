package kg.megacom.NaTv.mappers;

import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.entity.Channel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChannelMapperTest {


    ChannelMapper channelMapper = new ChannelMapperImpl();

    @Test
    void testChannelMapper(){
        Channel channel = new Channel();
        channel.setId(1l);
        channel.setName("ktk");

        ChannelDto channelDto =channelMapper.toDto(channel);

        assertEquals(channelDto.getId(),1l);
        assertEquals(channelDto.getName(),"ktk");

    }

}
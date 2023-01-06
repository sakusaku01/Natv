package kg.megacom.NaTv.mappers;

import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.entity.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ChannelMapper extends BaseMapper<Channel, ChannelDto>{
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

}

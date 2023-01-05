package kg.megacom.NaTv.models.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.entity.Channel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-02T23:04:47+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class ChannelMapperImpl implements ChannelMapper {

    @Override
    public Channel toEntity(ChannelDto d) {
        if ( d == null ) {
            return null;
        }

        Channel channel = new Channel();

        channel.setId( d.getId() );
        channel.setName( d.getName() );
        channel.setPhoto( d.getPhoto() );
        channel.setActive( d.getActive() );
        channel.setOrderNum( d.getOrderNum() );

        return channel;
    }

    @Override
    public ChannelDto toDto(Channel e) {
        if ( e == null ) {
            return null;
        }

        ChannelDto channelDto = new ChannelDto();

        channelDto.setId( e.getId() );
        channelDto.setName( e.getName() );
        channelDto.setPhoto( e.getPhoto() );
        channelDto.setActive( e.getActive() );
        channelDto.setOrderNum( e.getOrderNum() );

        return channelDto;
    }

    @Override
    public List<Channel> toEntities(List<ChannelDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Channel> list = new ArrayList<Channel>( d.size() );
        for ( ChannelDto channelDto : d ) {
            list.add( toEntity( channelDto ) );
        }

        return list;
    }

    @Override
    public List<ChannelDto> toDtos(List<Channel> e) {
        if ( e == null ) {
            return null;
        }

        List<ChannelDto> list = new ArrayList<ChannelDto>( e.size() );
        for ( Channel channel : e ) {
            list.add( toDto( channel ) );
        }

        return list;
    }
}

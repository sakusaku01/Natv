package kg.megacom.NaTv.models.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.dtos.OrderDetailDto;
import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.models.entity.Channel;
import kg.megacom.NaTv.models.entity.Order;
import kg.megacom.NaTv.models.entity.OrderDetail;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-30T11:59:06+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Override
    public OrderDetail toEntity(OrderDetailDto d) {
        if ( d == null ) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setId( d.getId() );
        orderDetail.setChannelId( channelDtoToChannel( d.getChannelId() ) );
        orderDetail.setOrderId( orderDtoToOrder( d.getOrderId() ) );
        orderDetail.setPrice( d.getPrice() );

        return orderDetail;
    }

    @Override
    public OrderDetailDto toDto(OrderDetail e) {
        if ( e == null ) {
            return null;
        }

        OrderDetailDto orderDetailDto = new OrderDetailDto();

        orderDetailDto.setId( e.getId() );
        orderDetailDto.setChannelId( channelToChannelDto( e.getChannelId() ) );
        orderDetailDto.setOrderId( orderToOrderDto( e.getOrderId() ) );
        orderDetailDto.setPrice( e.getPrice() );

        return orderDetailDto;
    }

    @Override
    public List<OrderDetail> toEntities(List<OrderDetailDto> d) {
        if ( d == null ) {
            return null;
        }

        List<OrderDetail> list = new ArrayList<OrderDetail>( d.size() );
        for ( OrderDetailDto orderDetailDto : d ) {
            list.add( toEntity( orderDetailDto ) );
        }

        return list;
    }

    @Override
    public List<OrderDetailDto> toDtos(List<OrderDetail> e) {
        if ( e == null ) {
            return null;
        }

        List<OrderDetailDto> list = new ArrayList<OrderDetailDto>( e.size() );
        for ( OrderDetail orderDetail : e ) {
            list.add( toDto( orderDetail ) );
        }

        return list;
    }

    protected Channel channelDtoToChannel(ChannelDto channelDto) {
        if ( channelDto == null ) {
            return null;
        }

        Channel channel = new Channel();

        channel.setId( channelDto.getId() );
        channel.setName( channelDto.getName() );
        channel.setPhoto( channelDto.getPhoto() );
        channel.setActive( channelDto.getActive() );
        channel.setOrderNum( channelDto.getOrderNum() );

        return channel;
    }

    protected Order orderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDto.getId() );
        order.setText( orderDto.getText() );
        order.setName( orderDto.getName() );
        order.setPhone( orderDto.getPhone() );
        order.setEmail( orderDto.getEmail() );
        order.setTotalPrice( orderDto.getTotalPrice() );
        order.setEditDate( orderDto.getEditDate() );
        order.setAddDate( orderDto.getAddDate() );
        order.setStatus( orderDto.getStatus() );

        return order;
    }

    protected ChannelDto channelToChannelDto(Channel channel) {
        if ( channel == null ) {
            return null;
        }

        ChannelDto channelDto = new ChannelDto();

        channelDto.setId( channel.getId() );
        channelDto.setName( channel.getName() );
        channelDto.setPhoto( channel.getPhoto() );
        channelDto.setActive( channel.getActive() );
        channelDto.setOrderNum( channel.getOrderNum() );

        return channelDto;
    }

    protected OrderDto orderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setText( order.getText() );
        orderDto.setName( order.getName() );
        orderDto.setPhone( order.getPhone() );
        orderDto.setEmail( order.getEmail() );
        orderDto.setTotalPrice( order.getTotalPrice() );
        orderDto.setEditDate( order.getEditDate() );
        orderDto.setAddDate( order.getAddDate() );
        orderDto.setStatus( order.getStatus() );

        return orderDto;
    }
}

package kg.megacom.NaTv.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.models.entity.Order;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-06T22:12:01+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDto d) {
        if ( d == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( d.getId() );
        order.setText( d.getText() );
        order.setName( d.getName() );
        order.setPhone( d.getPhone() );
        order.setEmail( d.getEmail() );
        order.setTotalPrice( d.getTotalPrice() );
        order.setEditDate( d.getEditDate() );
        order.setAddDate( d.getAddDate() );
        order.setStatus( d.getStatus() );

        return order;
    }

    @Override
    public OrderDto toDto(Order e) {
        if ( e == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( e.getId() );
        orderDto.setText( e.getText() );
        orderDto.setName( e.getName() );
        orderDto.setPhone( e.getPhone() );
        orderDto.setEmail( e.getEmail() );
        orderDto.setTotalPrice( e.getTotalPrice() );
        orderDto.setEditDate( e.getEditDate() );
        orderDto.setAddDate( e.getAddDate() );
        orderDto.setStatus( e.getStatus() );

        return orderDto;
    }

    @Override
    public List<Order> toEntities(List<OrderDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( d.size() );
        for ( OrderDto orderDto : d ) {
            list.add( toEntity( orderDto ) );
        }

        return list;
    }

    @Override
    public List<OrderDto> toDtos(List<Order> e) {
        if ( e == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( e.size() );
        for ( Order order : e ) {
            list.add( toDto( order ) );
        }

        return list;
    }
}

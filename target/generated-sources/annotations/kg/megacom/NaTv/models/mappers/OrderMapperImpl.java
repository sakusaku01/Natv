package kg.megacom.NaTv.models.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.models.entity.Order;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T09:03:05+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDto d) {
        if ( d == null ) {
            return null;
        }

        Order order = new Order();

        return order;
    }

    @Override
    public OrderDto toDto(Order e) {
        if ( e == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

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

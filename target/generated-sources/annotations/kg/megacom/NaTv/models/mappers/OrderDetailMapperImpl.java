package kg.megacom.NaTv.models.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.NaTv.models.dtos.OrderDetailDto;
import kg.megacom.NaTv.models.entity.OrderDetail;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T09:03:05+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Override
    public OrderDetail toEntity(OrderDetailDto d) {
        if ( d == null ) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();

        return orderDetail;
    }

    @Override
    public OrderDetailDto toDto(OrderDetail e) {
        if ( e == null ) {
            return null;
        }

        OrderDetailDto orderDetailDto = new OrderDetailDto();

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
}

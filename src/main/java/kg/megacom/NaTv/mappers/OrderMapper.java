package kg.megacom.NaTv.mappers;

import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.models.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto>{
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

}

package kg.megacom.NaTv.mappers;

import kg.megacom.NaTv.models.dtos.OrderDetailDto;
import kg.megacom.NaTv.models.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail, OrderDetailDto>{
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
}

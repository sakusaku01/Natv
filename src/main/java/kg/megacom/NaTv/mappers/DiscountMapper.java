package kg.megacom.NaTv.mappers;

import kg.megacom.NaTv.models.dtos.DiscountDto;
import kg.megacom.NaTv.models.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface DiscountMapper extends BaseMapper<Discount, DiscountDto>{
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);
}

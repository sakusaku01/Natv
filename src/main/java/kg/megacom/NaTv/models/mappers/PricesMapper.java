package kg.megacom.NaTv.models.mappers;

import kg.megacom.NaTv.models.dtos.PricesDto;
import kg.megacom.NaTv.models.entity.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PricesMapper extends BaseMapper<Prices, PricesDto>{

    PricesMapper INSTANCE = Mappers.getMapper(PricesMapper.class);
}

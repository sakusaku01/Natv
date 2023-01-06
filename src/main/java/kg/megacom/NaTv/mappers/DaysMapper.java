package kg.megacom.NaTv.mappers;

import kg.megacom.NaTv.models.dtos.DaysDto;
import kg.megacom.NaTv.models.entity.Days;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface DaysMapper extends BaseMapper<Days, DaysDto>{
    DaysMapper INSTANCE = Mappers.getMapper(DaysMapper.class);
}

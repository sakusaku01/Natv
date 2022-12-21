package kg.megacom.NaTv.models.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.NaTv.models.dtos.DaysDto;
import kg.megacom.NaTv.models.entity.Days;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T09:03:05+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class DaysMapperImpl implements DaysMapper {

    @Override
    public Days toEntity(DaysDto d) {
        if ( d == null ) {
            return null;
        }

        Days days = new Days();

        return days;
    }

    @Override
    public DaysDto toDto(Days e) {
        if ( e == null ) {
            return null;
        }

        DaysDto daysDto = new DaysDto();

        return daysDto;
    }

    @Override
    public List<Days> toEntities(List<DaysDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Days> list = new ArrayList<Days>( d.size() );
        for ( DaysDto daysDto : d ) {
            list.add( toEntity( daysDto ) );
        }

        return list;
    }

    @Override
    public List<DaysDto> toDtos(List<Days> e) {
        if ( e == null ) {
            return null;
        }

        List<DaysDto> list = new ArrayList<DaysDto>( e.size() );
        for ( Days days : e ) {
            list.add( toDto( days ) );
        }

        return list;
    }
}

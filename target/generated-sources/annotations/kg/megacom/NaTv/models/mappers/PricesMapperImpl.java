package kg.megacom.NaTv.models.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.NaTv.models.dtos.PricesDto;
import kg.megacom.NaTv.models.entity.Prices;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T09:03:05+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class PricesMapperImpl implements PricesMapper {

    @Override
    public Prices toEntity(PricesDto d) {
        if ( d == null ) {
            return null;
        }

        Prices prices = new Prices();

        return prices;
    }

    @Override
    public PricesDto toDto(Prices e) {
        if ( e == null ) {
            return null;
        }

        PricesDto pricesDto = new PricesDto();

        return pricesDto;
    }

    @Override
    public List<Prices> toEntities(List<PricesDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Prices> list = new ArrayList<Prices>( d.size() );
        for ( PricesDto pricesDto : d ) {
            list.add( toEntity( pricesDto ) );
        }

        return list;
    }

    @Override
    public List<PricesDto> toDtos(List<Prices> e) {
        if ( e == null ) {
            return null;
        }

        List<PricesDto> list = new ArrayList<PricesDto>( e.size() );
        for ( Prices prices : e ) {
            list.add( toDto( prices ) );
        }

        return list;
    }
}

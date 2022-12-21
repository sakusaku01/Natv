package kg.megacom.NaTv.models.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.NaTv.models.dtos.DiscountDto;
import kg.megacom.NaTv.models.entity.Discount;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T09:03:05+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class DiscountMapperImpl implements DiscountMapper {

    @Override
    public Discount toEntity(DiscountDto d) {
        if ( d == null ) {
            return null;
        }

        Discount discount = new Discount();

        return discount;
    }

    @Override
    public DiscountDto toDto(Discount e) {
        if ( e == null ) {
            return null;
        }

        DiscountDto discountDto = new DiscountDto();

        return discountDto;
    }

    @Override
    public List<Discount> toEntities(List<DiscountDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Discount> list = new ArrayList<Discount>( d.size() );
        for ( DiscountDto discountDto : d ) {
            list.add( toEntity( discountDto ) );
        }

        return list;
    }

    @Override
    public List<DiscountDto> toDtos(List<Discount> e) {
        if ( e == null ) {
            return null;
        }

        List<DiscountDto> list = new ArrayList<DiscountDto>( e.size() );
        for ( Discount discount : e ) {
            list.add( toDto( discount ) );
        }

        return list;
    }
}

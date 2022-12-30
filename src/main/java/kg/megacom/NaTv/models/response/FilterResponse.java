package kg.megacom.NaTv.models.response;

import kg.megacom.NaTv.models.entity.Prices;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface FilterResponse {
    List<String> getName();
    List<Boolean> getActive();

    List<DiscountResponse> getDiscount();
    List<BigDecimal> getPrice();

    List<BigDecimal> specificPrice();
    List<BigDecimal> minPrice();
    List<BigDecimal> maxPrice();

    List<Date> increaseDate();
    List<Date> decreaseDate();
}

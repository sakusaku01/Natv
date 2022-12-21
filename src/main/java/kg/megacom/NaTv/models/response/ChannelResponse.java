package kg.megacom.NaTv.models.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelResponse {
    Long id;
    String name;
    String image;
    BigDecimal price;
    List<DiscountResponse> discountResponses;

}

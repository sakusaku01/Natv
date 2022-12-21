package kg.megacom.NaTv.models.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

//@Setter
//@Getter
//@FieldDefaults(level = AccessLevel.PRIVATE)
public interface DiscountResponse {
    Integer getMinDays();
    Double getPercent();
}

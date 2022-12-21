package kg.megacom.NaTv.models.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

//@Setter
//@Getter
//@FieldDefaults(level = AccessLevel.PRIVATE)
public interface Response {

    Long getId();
    String getName();
    String getPhoto();
    BigDecimal getPrice();

}

package kg.megacom.NaTv.models.Request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DayRequest {
    String day;
}

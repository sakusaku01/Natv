package kg.megacom.NaTv.models.Request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;
    List<ChannelRequest> channels;

}

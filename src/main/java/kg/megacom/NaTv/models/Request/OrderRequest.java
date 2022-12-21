package kg.megacom.NaTv.models.Request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;
    List<ChannelRequest> channelRequest;

}

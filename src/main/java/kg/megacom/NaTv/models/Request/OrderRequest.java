package kg.megacom.NaTv.models.Request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

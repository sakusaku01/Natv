package kg.megacom.NaTv.models.dtos;


import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

@Getter
@Setter
public class OrderDetailDto {
    Long id;
    ChannelDto channelId;
    OrderDto orderId;
    BigDecimal price;
}

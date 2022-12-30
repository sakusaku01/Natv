package kg.megacom.NaTv.models.dtos;

import kg.megacom.NaTv.models.entity.Channel;
import kg.megacom.NaTv.models.entity.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
public class OrderDetailDto {
    Long id;
    ChannelDto channelId;
    OrderDto orderId;
    BigDecimal price;
}

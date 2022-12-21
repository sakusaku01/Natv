package kg.megacom.NaTv.models.dtos;

import kg.megacom.NaTv.models.entity.Channel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class PricesDto {
    Long id;
    Date startDate;
    Date endDate;
    BigDecimal price;
    Channel channelId;
}

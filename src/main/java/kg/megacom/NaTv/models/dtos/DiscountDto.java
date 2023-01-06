package kg.megacom.NaTv.models.dtos;

import kg.megacom.NaTv.models.entity.Channel;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Setter
@Getter
public class DiscountDto {
    Long id;
    Double percent;
    Date startDate;
    Date endDate;
    int minDays;
    Channel channelId;


}

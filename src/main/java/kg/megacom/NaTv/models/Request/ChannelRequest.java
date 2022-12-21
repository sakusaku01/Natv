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
public class ChannelRequest {
    Long channelId;
    BigDecimal price;
    List<DayRequest> days;

}

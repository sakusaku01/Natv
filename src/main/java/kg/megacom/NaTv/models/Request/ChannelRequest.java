package kg.megacom.NaTv.models.Request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import java.util.List;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelRequest {
    Long channelId;
    BigDecimal price;
    List<DayRequest> days;



}

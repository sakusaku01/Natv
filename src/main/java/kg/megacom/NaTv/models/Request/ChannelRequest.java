package kg.megacom.NaTv.models.Request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kg.megacom.NaTv.models.entity.Channel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.PrePersist;
import java.math.BigDecimal;
import java.util.Date;
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

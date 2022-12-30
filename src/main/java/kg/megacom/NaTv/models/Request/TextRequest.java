package kg.megacom.NaTv.models.Request;

import kg.megacom.NaTv.models.entity.Channel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TextRequest {

    Long channelId;
    String text;
    List<DayRequest> dates;
}

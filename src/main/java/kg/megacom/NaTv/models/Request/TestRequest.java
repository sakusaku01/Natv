package kg.megacom.NaTv.models.Request;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel
public class TestRequest {

    List<ChannelRequest> channelRequests;
}

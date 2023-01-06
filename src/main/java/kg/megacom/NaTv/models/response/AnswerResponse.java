package kg.megacom.NaTv.models.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponse {
    BigDecimal totalPrice;

    BigDecimal totalPriceWithoutDiscount;
    List<AnswerChannelResponse> channelResponses;



}

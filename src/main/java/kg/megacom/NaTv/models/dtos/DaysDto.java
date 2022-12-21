package kg.megacom.NaTv.models.dtos;

import kg.megacom.NaTv.models.entity.OrderDetail;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class DaysDto {
    Long id;
    OrderDetail orderDetailId;
    int day;
}

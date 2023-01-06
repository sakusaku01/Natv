package kg.megacom.NaTv.models.dtos;

import kg.megacom.NaTv.models.status.Status;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Date;
@Setter
@Getter
public class OrderDto {
    Long id;
    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;
    Date editDate;
    Date addDate;
    Status status;
}

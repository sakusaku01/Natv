package kg.megacom.NaTv.models.entity;

import kg.megacom.NaTv.models.status.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;
    @Temporal(TemporalType.DATE)
    Date editDate;
    @Temporal(TemporalType.DATE)
    Date addDate;
    Status status;
}

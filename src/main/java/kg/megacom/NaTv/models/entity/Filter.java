package kg.megacom.NaTv.models.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_filter")
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "discount")
    Boolean discount;
    @Column(name = "isChannelActive")
    Boolean isChannelActive;
    @Column(name = "price")
    BigDecimal price;
    @Column(name = "min_price")
    BigDecimal minPrice;
    @Column(name = "max_price")
    BigDecimal maxPrice;

}

package kg.megacom.NaTv.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_channel")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique=true)
    String name;
    String photo;
    Boolean  active;
    int orderNum;

    @Temporal(TemporalType.DATE)
    Date addDate;
    @Temporal(TemporalType.DATE)
    Date editDate;

    @PrePersist
    protected void onCreate(){

        addDate = new Date();
        editDate = new Date();
    }

    @PreUpdate
    private void onUpdate(){
        editDate=new Date();
    }


    @JsonIgnore
    @OneToMany(mappedBy = "channelId")
    List<Prices> prices;


    @JsonIgnore
    @OneToMany(mappedBy = "channelId")
    List<Discount> discounts;

}

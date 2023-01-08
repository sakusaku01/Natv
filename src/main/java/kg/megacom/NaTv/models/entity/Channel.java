package kg.megacom.NaTv.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @JsonManagedReference
    @OneToMany(mappedBy = "channelId")
    List<Prices> prices;


    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "channelId")
    List<Discount> discounts;

}

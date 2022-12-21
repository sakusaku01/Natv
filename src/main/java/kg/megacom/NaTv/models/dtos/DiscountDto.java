package kg.megacom.NaTv.models.dtos;

import kg.megacom.NaTv.models.entity.Channel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Setter
@Getter
public class DiscountDto {
    Long id;
    Double percent;
    Date startDate;
    Date endDate;
    int minDays;
    Channel channelId;


}

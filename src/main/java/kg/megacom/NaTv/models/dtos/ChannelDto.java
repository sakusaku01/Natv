package kg.megacom.NaTv.models.dtos;

import kg.megacom.NaTv.services.microServices.Photo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelDto {
    Long id;
    String name;
    String photo;
    Boolean active;
    int orderNum;
}

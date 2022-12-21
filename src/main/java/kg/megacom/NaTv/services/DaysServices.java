package kg.megacom.NaTv.services;

import kg.megacom.NaTv.models.dtos.DaysDto;

import java.util.List;

public interface DaysServices extends BaseServices<DaysDto>{
    int stringParse(List<String> days);
}

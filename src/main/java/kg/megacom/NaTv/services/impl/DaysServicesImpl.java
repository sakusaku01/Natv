package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dtos.DaysDto;
import kg.megacom.NaTv.models.mappers.DaysMapper;
import kg.megacom.NaTv.repositories.DaysRepository;
import kg.megacom.NaTv.services.DaysServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DaysServicesImpl implements DaysServices {

    @Autowired
    private DaysRepository rep;

    @Override
    public DaysDto save(DaysDto daysDto) {
        return DaysMapper.INSTANCE.toDto(rep.save(DaysMapper.INSTANCE.toEntity(daysDto)));
    }

    @Override
    public DaysDto findById(Long id) {
        return DaysMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("error")));
    }

    @Override
    public List<DaysDto> findAll() {
        return DaysMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public int stringParse(List<String> days){
        if (days.size() == 0) {
            return 0;
        }
        int length = days.get(0).length();
        String first = days.get(0);
        int count = 1;

        for (int i = 0; i < length - 1; i++)
        {
            if ((first.charAt(i) == ' ') && (first.charAt(i + 1) != ' '))
            {
                count++;
            }
        }
        return count * days.size();

    }
}

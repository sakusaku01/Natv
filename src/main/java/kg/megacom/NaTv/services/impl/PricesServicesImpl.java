package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dtos.PricesDto;
import kg.megacom.NaTv.models.mappers.PricesMapper;
import kg.megacom.NaTv.repositories.PricesRepository;
import kg.megacom.NaTv.services.PricesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PricesServicesImpl implements PricesServices {

    @Autowired
    private PricesRepository rep;


    @Override
    public PricesDto save(PricesDto pricesDto) {
        return PricesMapper.INSTANCE.toDto(rep.save(PricesMapper.INSTANCE.toEntity(pricesDto)));
    }

    @Override
    public PricesDto findById(Long id) {
        return PricesMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("error")));
    }

    @Override
    public List<PricesDto> findAll() {
        return PricesMapper.INSTANCE.toDtos(rep.findAll());
    }
}

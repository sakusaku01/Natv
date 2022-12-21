package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dtos.DiscountDto;
import kg.megacom.NaTv.models.mappers.DiscountMapper;
import kg.megacom.NaTv.repositories.DiscountRepository;
import kg.megacom.NaTv.services.DiscountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscountServicesImpl implements DiscountServices {

    @Autowired
    private DiscountRepository rep;

    @Override
    public DiscountDto save(DiscountDto discountDto) {
        return DiscountMapper.INSTANCE.toDto(rep.save(DiscountMapper.INSTANCE.toEntity(discountDto)));
    }

    @Override
    public DiscountDto findById(Long id) {
        return DiscountMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("error")));
    }

    @Override
    public List<DiscountDto> findAll() {
        return DiscountMapper.INSTANCE.toDtos(rep.findAll());
    }
}

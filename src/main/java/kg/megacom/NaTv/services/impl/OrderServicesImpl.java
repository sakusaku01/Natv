package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.models.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.models.mappers.OrderMapper;
import kg.megacom.NaTv.models.utils.ResourceBundle;
import kg.megacom.NaTv.models.utils.models.Language;
import kg.megacom.NaTv.repositories.OrderRepository;
import kg.megacom.NaTv.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServicesImpl implements OrderServices {

    @Autowired
    private OrderRepository rep;

    @Override
    public OrderDto save(OrderDto orderDto) {
        return OrderMapper.INSTANCE.toDto(rep.save(OrderMapper.INSTANCE.toEntity(orderDto)));
    }

    @Override
    public OrderDto findById(Long id,int lang) {
        Language language  = Language.getLang(lang);
        return OrderMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new EntityNotFoundExc(ResourceBundle.periodMessages(language,"orderNotFound"))));
    }

    @Override
    public List<OrderDto> findAll() {
        return OrderMapper.INSTANCE.toDtos(rep.findAll());
    }
}

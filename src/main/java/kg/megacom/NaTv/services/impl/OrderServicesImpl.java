package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.exceptions.ValueNotFoundExc;
import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.exceptions.EntityNotFoundExc;
import kg.megacom.NaTv.mappers.OrderMapper;
import kg.megacom.NaTv.utils.ResourceBundle;
import kg.megacom.NaTv.utils.models.Language;
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
    public OrderDto save(OrderDto orderDto,int lang) {
        return OrderMapper.INSTANCE.toDto(rep.save(OrderMapper.INSTANCE.toEntity(orderDto)));
    }

    @Override
    public OrderDto findById(Long id,int lang) {
        Language language  = Language.getLang(lang);
        return OrderMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new EntityNotFoundExc(ResourceBundle.periodMessages(language,"orderNotFound"))));
    }

    @Override
    public List<OrderDto> findAll(int lang) {
        Language language  = Language.getLang(lang);
        if (OrderMapper.INSTANCE.toDtos(rep.findAll()).isEmpty()){
            throw new ValueNotFoundExc(ResourceBundle.periodMessages(language,"ordersNotCreated"));
        }
        return OrderMapper.INSTANCE.toDtos(rep.findAll());
    }
}

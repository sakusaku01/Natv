package kg.megacom.NaTv.services.impl;

import kg.megacom.NaTv.models.Request.OrderRequest;
import kg.megacom.NaTv.models.dtos.OrderDetailDto;
import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.models.mappers.OrderDetailMapper;
import kg.megacom.NaTv.models.status.Status;
import kg.megacom.NaTv.repositories.OrderDetailRepository;
import kg.megacom.NaTv.services.OrderDetailServices;
import kg.megacom.NaTv.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrderDetailServicesImpl implements OrderDetailServices {

    private final OrderDetailRepository rep;
    private final OrderServices services;

    public OrderDetailServicesImpl(OrderDetailRepository rep, OrderServices services) {
        this.rep = rep;
        this.services = services;
    }


    @Override
    public OrderDetailDto save(OrderDetailDto orderDetailDto) {
        return OrderDetailMapper.INSTANCE.toDto(rep.save(OrderDetailMapper.INSTANCE.toEntity(orderDetailDto)));
    }

    @Override
    public OrderDetailDto findById(Long id) {
        return OrderDetailMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("error")));
    }

    @Override
    public List<OrderDetailDto> findAll() {
        return OrderDetailMapper.INSTANCE.toDtos(rep.findAll());
    }


//    @Override
//    public List<OrderDetailDto> makeOrder(OrderRequest request) {
//        OrderDto dto = new OrderDto();
//        dto.setName(request.getName());
//        dto.setPhone(request.getPhone());
//        dto.setEmail(request.getEmail());
//        dto.setText(request.getText());
//        dto.setStatus(Status.STRING);
//        dto.setTotalPrice(request.getTotalPrice());
//        dto.setAddDate(new Date());
//        dto.setEditDate(new Date());
//
//        services.save(dto);
//
//
//    }
}

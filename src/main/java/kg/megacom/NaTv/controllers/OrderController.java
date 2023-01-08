package kg.megacom.NaTv.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NaTv.models.Request.OrderRequest;
import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.services.OrderDetailServices;
import kg.megacom.NaTv.services.OrderServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/or")
@Api(tags = Swagger2Config.Order)
public class OrderController {
    private final OrderServices services;

    private final OrderDetailServices od;

    public OrderController(OrderServices services, OrderDetailServices od) {
        this.services = services;
        this.od = od;
    }

    @PostMapping("/save")
    @ApiOperation(value = "Сохранение заказов")
    public ResponseEntity<?> save(@RequestBody OrderDto dto,int lang) {
        try {
            return ResponseEntity.ok(services.save(dto,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @PostMapping("/make/order")
    @ApiOperation(value = "Сделать заказ")
    public ResponseEntity<?> makeOrder(@RequestBody OrderRequest request,@RequestParam int lang) {
        try {
            return ResponseEntity.ok(od.makeOrder(request,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @GetMapping("/get")
    @ApiOperation(value = "Поиск заказов по id")
    public  ResponseEntity<?> findById(@RequestParam Long id,
                                       @RequestParam int lang) {
            return ResponseEntity.ok(services.findById(id,lang));
    }

    @GetMapping("/get/all")
    @ApiOperation(value = "Поиск всех заказов")
    public ResponseEntity<?> findAll(@RequestParam int lang) {
        try {
            return ResponseEntity.ok(services.findAll(lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
}

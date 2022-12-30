package kg.megacom.NaTv.controllers;


import io.swagger.annotations.Api;
import kg.megacom.NaTv.models.Request.OrderRequest;
import kg.megacom.NaTv.models.dtos.OrderDto;
import kg.megacom.NaTv.services.OrderDetailServices;
import kg.megacom.NaTv.services.OrderServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/or")
@Api(tags = Swagger2Config.Order)
public class OrderController {
    @Autowired
    private OrderServices services;

    @Autowired
    private OrderDetailServices od;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrderDto dto) {
        try {
            return ResponseEntity.ok(services.save(dto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @PostMapping("/make/order")
    public ResponseEntity<?> makeOrder(@RequestBody OrderRequest request,@RequestParam int lang) {
        try {
            return ResponseEntity.ok(od.makeOrder(request,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @GetMapping("/get")
    public  ResponseEntity<?> findById(@RequestParam Long id,
                                       @RequestParam int lang) {
            return ResponseEntity.ok(services.findById(id,lang));
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(services.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
}

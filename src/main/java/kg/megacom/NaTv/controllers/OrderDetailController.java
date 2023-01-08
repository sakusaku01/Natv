package kg.megacom.NaTv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NaTv.models.dtos.OrderDetailDto;
import kg.megacom.NaTv.services.OrderDetailServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/ord")
@Api(tags = Swagger2Config.OrderD)
public class OrderDetailController {
    @Autowired
    private OrderDetailServices services;


    @PostMapping("/save")
    @ApiOperation(value = "Сохранение деталей заказов")
    public ResponseEntity<?> save(@RequestBody OrderDetailDto dto,int lang) {
        try {
            return ResponseEntity.ok(services.save(dto,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @GetMapping("/get")
    @ApiOperation(value = "Поиск деталей заказов по id")
    public  ResponseEntity<?> findById(@RequestParam Long id,@RequestParam int lang) {
        return ResponseEntity.ok(services.findById(id,lang));
    }

    @GetMapping("/get/all")
    @ApiOperation(value = "Поиск всех деталей заказов")
    public ResponseEntity<?> findAll(@RequestParam int lang) {
        try {
            return ResponseEntity.ok(services.findAll(lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


}

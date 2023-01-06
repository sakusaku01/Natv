package kg.megacom.NaTv.controllers;

import io.swagger.annotations.Api;
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
    public ResponseEntity<?> save(@RequestBody OrderDetailDto dto,int lang) {
        try {
            return ResponseEntity.ok(services.save(dto,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @GetMapping("/get")
    public  ResponseEntity<?> findById(@RequestParam Long id,@RequestParam int lang) {
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

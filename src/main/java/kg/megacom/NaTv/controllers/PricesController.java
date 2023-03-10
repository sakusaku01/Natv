package kg.megacom.NaTv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NaTv.models.dtos.PricesDto;
import kg.megacom.NaTv.services.PricesServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/pr")
@Api(tags = Swagger2Config.Prices)

public class PricesController {
    @Autowired
    private PricesServices services;

    @PostMapping("/save")
    @ApiOperation(value = "Сохранение цен")
    public ResponseEntity<?> save(@RequestBody PricesDto dto, int lang) {
        try {
            return ResponseEntity.ok(services.save(dto,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @GetMapping("/get")
    @ApiOperation(value = "Поиск цен по id")
    public  ResponseEntity<?> findById(@RequestParam Long id,@RequestParam int lang) {
        return ResponseEntity.ok(services.findById(id,lang));
    }

    @GetMapping("/get/all")
    @ApiOperation(value = "Поиск всех цен")
    public ResponseEntity<?> findAll(@RequestParam int lang) {
        try {
            return ResponseEntity.ok(services.findAll(lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
}

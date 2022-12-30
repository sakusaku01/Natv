package kg.megacom.NaTv.controllers;

import io.swagger.annotations.Api;
import kg.megacom.NaTv.models.Request.TextRequest;
import kg.megacom.NaTv.models.dtos.DiscountDto;
import kg.megacom.NaTv.models.dtos.OrderDetailDto;
import kg.megacom.NaTv.models.status.DescAsc;
import kg.megacom.NaTv.services.OrderDetailServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ord")
@Api(tags = Swagger2Config.OrderD)
public class OrderDetailController {
    @Autowired
    private OrderDetailServices services;

    @PostMapping("/channel/filter")
    public ResponseEntity<?> channelsFilter(@RequestParam String name,
                                            @RequestParam boolean discount,
                                            @RequestParam boolean isChannelActive,
                                            @RequestParam BigDecimal specificPrice,
                                            @RequestParam BigDecimal minPrice,
                                            @RequestParam BigDecimal maxPrice,
                                            @RequestParam DescAsc descAsc) {
        try {
            return ResponseEntity.ok(services.filter(name,discount,isChannelActive,specificPrice,minPrice,maxPrice,descAsc));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrderDetailDto dto) {
        try {
            return ResponseEntity.ok(services.save(dto));
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

//    @PostMapping  ("/set/text")
//    public ResponseEntity<?> setText(@RequestBody List<TextRequest> textRequest) {
//        try {
//            return ResponseEntity.ok(services.countText(textRequest));
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
//        }
//    }
}

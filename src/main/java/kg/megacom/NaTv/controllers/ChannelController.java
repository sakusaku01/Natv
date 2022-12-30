package kg.megacom.NaTv.controllers;

import io.swagger.annotations.Api;
import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.services.ChannelServices;
import kg.megacom.NaTv.services.microServices.FileServiceFeign;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ch")
@Api(tags = Swagger2Config.Channel)
public class ChannelController {
    @Autowired
    private ChannelServices services;

//    @Autowired
//    private FileServiceFeign feign;

//    @PostMapping("/upload/photo")
//    public String saveChannel(@RequestParam String name,
//                              @RequestParam MultipartFile multipartFile,
//                              @RequestParam int orderNum) {
//
//        Photo fileName = feign.storeFile(multipartFile);
//
//        return fileName;
//
//    }
    @PostMapping("/save/channel")
    public ResponseEntity<?> saveChannel(@RequestParam String name,
                                         @RequestParam MultipartFile multipartFile,
                                         @RequestParam int orderNum) {
        try {
            return ResponseEntity.ok(services.saveChannel(name,multipartFile,orderNum));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ChannelDto dto) {
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



    @GetMapping("/get/channels/info")
    public ResponseEntity<?> findOrderDInfo(@RequestParam int page,@RequestParam int size) {
        try {
            return ResponseEntity.ok(services.channelsResponseDiscounts(page,size));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
//    @PostMapping("/ghbdttnbrb")
//    public List<?> ghbdtnbrb (
//            @RequestParam(value = "price", required = false) BigDecimal price){
//        Dao dao = new Dao();
//        return dao.findByAll(price);
//    }
}

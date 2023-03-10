package kg.megacom.NaTv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NaTv.exceptions.ValueNotFoundExc;
import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.status.MaxMin;
import kg.megacom.NaTv.services.ChannelServices;

import kg.megacom.NaTv.swagger.Swagger2Config;
import kg.megacom.NaTv.utils.ResourceBundle;
import kg.megacom.NaTv.utils.models.Language;
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

    @PostMapping("/save/channel")
    @ApiOperation(value = "Сохранение каналов с фото")
    public ResponseEntity<?> saveChannel(@RequestParam String name,
                                         @RequestParam MultipartFile multipartFile,
                                         @RequestParam int orderNum,
                                         @RequestParam Boolean isActive,
                                         @RequestParam int lang) {
        try {
            return ResponseEntity.ok(services.saveChannel(name,multipartFile,orderNum,isActive,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @PostMapping("/save")
    @ApiOperation(value = "Сохранение каналов")
    public ResponseEntity<?> save(@RequestBody ChannelDto dto, int lang) {
        try {
            return ResponseEntity.ok(services.save(dto,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @GetMapping("/get")
    @ApiOperation(value = "Поиск каналов по id")
    public  ResponseEntity<?> findById(@RequestParam Long id,@RequestParam int lang) {
        return ResponseEntity.ok(services.findById(id,lang));
    }

    @GetMapping("/get/all")
    @ApiOperation(value = "Вывод всех каналов")
    public ResponseEntity<?> findAll(@RequestParam int lang) {
        try {
            return ResponseEntity.ok(services.findAll(lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }



    @GetMapping("/get/channels/info")
    @ApiOperation(value = "Вывод всех каналов со скидками и ценами")
    public ResponseEntity<?> findOrderDInfo(@RequestParam int page,@RequestParam int size, @RequestParam int lang) {
        try {
            Language language = Language.getLang(lang);
            if(ResponseEntity.ok(services.channelsResponseDiscounts(page,size)).getBody().isEmpty()){
                throw new ValueNotFoundExc(ResourceBundle.periodMessages(language,"channelNotCreatedYet"));
            }
            return ResponseEntity.ok(services.channelsResponseDiscounts(page,size));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/get/filter")
    @ApiOperation(value = "Фильтрация каналов")
    public List<?> getFilter (
            @RequestParam(value = "price", required = false) BigDecimal price,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "active", required = false) Boolean isActive,
            @RequestParam(value = "discount", required = false) Boolean isDiscount,
            @RequestParam(value = "minOrMinPrice", required = false) MaxMin minMaxPrice,
            @RequestParam(value = "orderNum", required = false) Boolean orderNum){


        return services.findByAll(name,price,isActive,isDiscount,orderNum,minMaxPrice);
    }
}

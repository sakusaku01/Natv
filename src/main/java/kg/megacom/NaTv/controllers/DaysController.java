package kg.megacom.NaTv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import kg.megacom.NaTv.models.Request.ChannelRequest;
import kg.megacom.NaTv.models.Request.DayRequest;
import kg.megacom.NaTv.models.Request.TestRequest;
import kg.megacom.NaTv.models.dtos.ChannelDto;
import kg.megacom.NaTv.models.dtos.DaysDto;
import kg.megacom.NaTv.services.DaysServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/days")
@Api(tags = Swagger2Config.Days)
public class DaysController {
    @Autowired
    private DaysServices services;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody DaysDto dto) {
        try {
            return ResponseEntity.ok(services.save(dto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

//    @PostMapping("/parse")
//    public ResponseEntity<?> parse(@RequestBody List<ChannelRequest> channelRequests) {
//        try {
//            if(channelRequests.size()==0)return null;
//            else return ResponseEntity.ok(services.stringParse(channelRequests));
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
//        }
//
//    }
    @PostMapping("/count")
    public ResponseEntity<?> count(@RequestBody List<DayRequest> dayRequests) {
        try {
            if(dayRequests.size()==0)return null;
            else return ResponseEntity.ok(services.countDays(dayRequests));
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

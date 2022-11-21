package com.example.firma.Controller;

import com.example.firma.Payload.ApiResponse;
import com.example.firma.Payload.BolimDto;
import com.example.firma.Servis.BolimServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bolim")
public class BolimController {
    @Autowired
    BolimServis bolimServis;

    @PostMapping("/post")
    public HttpEntity<?> post(@RequestBody BolimDto  bolimDto){
        ApiResponse apiResponse=bolimServis.BolimPost(bolimDto);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());

    }
    @GetMapping("/oqish")
    public HttpEntity<?> oqish(){
        ApiResponse apiResponse=bolimServis.BolimGet();
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());

    }
    @GetMapping("/oqish/{id}")
    public HttpEntity<?> Get(@PathVariable Integer id){
        ApiResponse apiResponse=bolimServis.BolimGetId(id);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());

    }
    @PutMapping("/put/{id}")
    public HttpEntity<?> tahrirlash(@PathVariable Integer id,@RequestBody BolimDto bolimDto){
        ApiResponse apiResponse=bolimServis.BolimPut(id,bolimDto);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());

    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> ochirish(@PathVariable Integer id){
        ApiResponse apiResponse=bolimServis.BolimDelet(id);
        return  ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());

    }

}

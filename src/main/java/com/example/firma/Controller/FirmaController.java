package com.example.firma.Controller;

import com.example.firma.Payload.ApiResponse;
import com.example.firma.Payload.FirmaDto;
import com.example.firma.Servis.FirmaServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/firma")
public class FirmaController {
    @Autowired
    FirmaServis firmaServis;

    @PostMapping("/post")
    public HttpEntity<?> joylash(@RequestBody FirmaDto firmaDto){
        ApiResponse apiResponse=firmaServis.FirmaPost(firmaDto);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());
    }

    @GetMapping("/get")
    public HttpEntity<?> olish(){
        ApiResponse apiResponse=firmaServis.FirmaGet();
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());

    }

    @GetMapping("/get/{id}")
    public HttpEntity<?> olish(@PathVariable Integer id){
        ApiResponse apiResponse=firmaServis.FirmaGetId(id);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());

    }

    @PutMapping("/put/{id}")
    public HttpEntity<?> tahrirlash(@PathVariable Integer id,@RequestBody FirmaDto firmaDto){
        ApiResponse apiResponse=firmaServis.FirmaPut(id,firmaDto);
        return  ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());

    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse apiResponse=firmaServis.FirmaDelete(id);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }

}

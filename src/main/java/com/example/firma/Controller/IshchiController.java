package com.example.firma.Controller;

import com.example.firma.Payload.ApiResponse;
import com.example.firma.Payload.IshchiDto;
import com.example.firma.Servis.IshchiServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ishchi")
public class IshchiController {
    @Autowired
    IshchiServis ishchiServis;

    @PostMapping("/post")
    public HttpEntity<?> post(@RequestBody IshchiDto ishchiDto){
        ApiResponse apiResponse=ishchiServis.IshchiPost(ishchiDto);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());

    }
    @GetMapping("/get/{id}")
    public HttpEntity<?> olish(@PathVariable Integer id){
        ApiResponse apiResponse=ishchiServis.IshchiGet(id);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());

    }
    @GetMapping("/get")
    public HttpEntity<?> olish(){
        ApiResponse apiResponse=ishchiServis.ishchiGetId();
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());

    }
    @PutMapping("/put/{id}")
    public HttpEntity<?> tahrirlash(@PathVariable Integer id,@RequestBody IshchiDto ishchiDto){
        ApiResponse apiResponse=ishchiServis.IshchiPut(id,ishchiDto);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK : HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());

    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse apiResponse=ishchiServis.IshchiDelet(id);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());

    }

}

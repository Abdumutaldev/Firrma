package com.example.firma.Payload;

import com.example.firma.Entity.Manzil;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class IshchiDto {

    private Integer id;

    private String ismi;

    private String tel;

    private Integer bolimId;

    private String vil,tum,kocha,uy;

}

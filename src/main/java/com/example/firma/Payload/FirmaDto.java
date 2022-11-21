package com.example.firma.Payload;

import com.example.firma.Entity.Manzil;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class FirmaDto {

    private Integer id;

    private String nomi;

    private String direktor;

    private String vil,tum,kocha,uy;


}

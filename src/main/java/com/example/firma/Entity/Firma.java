package com.example.firma.Entity;

import com.example.firma.Repository.ManzilRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nomi;
    @Column(nullable = false)
    private String direktor;

    @OneToOne
    private Manzil manzil;



}

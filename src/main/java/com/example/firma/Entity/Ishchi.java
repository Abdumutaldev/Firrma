package com.example.firma.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Ishchi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String ismi;
    @Column(nullable = false)
    private String tel;

    @OneToOne
    private Manzil manzil;

    @ManyToOne
    private Bolim bolim;

}

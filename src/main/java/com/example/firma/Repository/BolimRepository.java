package com.example.firma.Repository;

import com.example.firma.Entity.Bolim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BolimRepository extends JpaRepository<Bolim,Integer> {
 boolean existsByNomi(String nomi);

}

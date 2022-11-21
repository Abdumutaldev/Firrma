package com.example.firma.Repository;

import com.example.firma.Entity.Manzil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManzilRepository extends JpaRepository<Manzil,Integer> {
    boolean existsByUyAndKocha(String uy, String kocha);
}

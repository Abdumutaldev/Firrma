package com.example.firma.Repository;

import com.example.firma.Entity.Firma;
import com.example.firma.Entity.Manzil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FirmaRepository extends JpaRepository<Firma,Integer> {
 boolean existsByNomi(String nomi);
 Optional<Firma> findByManzilId(Integer manzil_id);
}

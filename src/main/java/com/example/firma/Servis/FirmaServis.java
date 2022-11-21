package com.example.firma.Servis;

import com.example.firma.Entity.Firma;
import com.example.firma.Entity.Manzil;
import com.example.firma.Payload.ApiResponse;
import com.example.firma.Payload.FirmaDto;
import com.example.firma.Repository.FirmaRepository;
import com.example.firma.Repository.ManzilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FirmaServis {
    @Autowired
    FirmaRepository firmaRepository;

    @Autowired
    ManzilRepository manzilRepository;


    public ApiResponse FirmaPost(FirmaDto firmaDto) {
        boolean b = firmaRepository.existsByNomi(firmaDto.getNomi());
        boolean b1 = manzilRepository.existsByUyAndKocha(firmaDto.getUy(), firmaDto.getKocha());
        if (b) return new ApiResponse("Bunday firma mavjud ",false);
        if (b1) return new ApiResponse("Manzil xato kiritildi",false);
        Firma firma=new Firma();
        firma.setNomi(firmaDto.getNomi());
        firma.setDirektor(firmaDto.getDirektor());
        Manzil manzil=new Manzil();
        manzil.setVil(firmaDto.getVil());
        manzil.setTum(firmaDto.getTum());
        manzil.setKocha(firmaDto.getKocha());
        manzil.setUy(firmaDto.getUy());
        manzilRepository.save(manzil);
        firma.setManzil(manzil);
        firmaRepository.save(firma);
        return new ApiResponse("Firma malumotlari qoshildi",true);
    }

    public ApiResponse FirmaGet() {
        return new ApiResponse(firmaRepository.findAll().toString(),true);
    }


    public ApiResponse FirmaGetId(Integer id) {
        Optional<Firma> byId = firmaRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Bunday idli Firma mavjud emas",false);
        return new ApiResponse(byId.toString(),true);
    }

    public ApiResponse FirmaPut(Integer id, FirmaDto firmaDto) {
        Optional<Firma> byId = firmaRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Bunday idli firma mavjud emas",false);
        Firma firma = byId.get();
        firma.setNomi(firmaDto.getNomi());
        firma.setDirektor(firmaDto.getDirektor());
        Manzil manzil = byId.get().getManzil();
        manzil.setVil(firmaDto.getVil());
        manzil.setTum(firmaDto.getTum());
        manzil.setKocha(firmaDto.getKocha());
        manzil.setUy(firmaDto.getUy());
        manzilRepository.save(manzil);
        firma.setManzil(manzil);
        firmaRepository.save(firma);
        return new ApiResponse("Malumotlar tahrirlandi ",true);


    }

    public ApiResponse FirmaDelete(Integer id) {
        Optional<Firma> byManzilId = firmaRepository.findByManzilId(id);
        firmaRepository.deleteById(id);
        manzilRepository.deleteById(byManzilId.get().getId());

        return new ApiResponse("Malumotlar ochirildi",true);
    }
}

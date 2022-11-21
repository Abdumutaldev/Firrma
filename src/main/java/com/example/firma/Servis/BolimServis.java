package com.example.firma.Servis;

import com.example.firma.Entity.Bolim;
import com.example.firma.Entity.Firma;
import com.example.firma.Payload.ApiResponse;
import com.example.firma.Payload.BolimDto;
import com.example.firma.Repository.BolimRepository;
import com.example.firma.Repository.FirmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.FacesRequestAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class BolimServis {
    @Autowired
    BolimRepository bolimRepository;

    @Autowired
    FirmaRepository firmaRepository;
    public ApiResponse BolimPost(BolimDto bolimDto) {
        boolean b = bolimRepository.existsByNomi(bolimDto.getNomi());
        if (b) return new ApiResponse("Bunday bolim mavjud ",false);
       Bolim bolim=new Bolim();
       Firma firma=new Firma();
        bolim.setNomi(bolimDto.getNomi());
        firma.setId(bolimDto.getFirmaId());
        bolim.setFirma(firma);
       bolimRepository.save(bolim);
       return new ApiResponse("Malumotlar saqlndi",true);



    }

    public ApiResponse BolimGet() {
        List<Bolim> all = bolimRepository.findAll();
        if (all.isEmpty()) return new ApiResponse("Malumotlar mavjud emas ",false);
        return new ApiResponse(all.toString(),true);


    }


    public ApiResponse BolimGetId(Integer id) {
        Optional<Bolim> byId = bolimRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Bunday idli bolim mavjud emas",false);
        return new ApiResponse(byId.toString(),true);

    }

    public ApiResponse BolimPut(Integer id, BolimDto bolimDto) {
        Optional<Bolim> byId = bolimRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Bunday idli malumot mavjud emas", false);
        Bolim bolim = byId.get();
        bolim.setNomi(bolimDto.getNomi());
        bolimRepository.save(bolim);
        return new ApiResponse("Malumotlar tahrirlandi", true);
    }


    public ApiResponse BolimDelet(Integer id) {
        bolimRepository.deleteById(id);
        return new ApiResponse("Malumotlar ochirildi",true);


    }
}



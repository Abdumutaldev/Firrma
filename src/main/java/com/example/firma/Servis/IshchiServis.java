package com.example.firma.Servis;

import com.example.firma.Entity.Bolim;
import com.example.firma.Entity.Ishchi;
import com.example.firma.Entity.Manzil;
import com.example.firma.Payload.ApiResponse;
import com.example.firma.Payload.IshchiDto;
import com.example.firma.Repository.BolimRepository;
import com.example.firma.Repository.IshchiRepository;
import com.example.firma.Repository.ManzilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IshchiServis {
    @Autowired
    IshchiRepository ishchiRepository;

    @Autowired
    ManzilRepository manzilRepository;

    @Autowired
    BolimRepository bolimRepository;
    public ApiResponse IshchiPost(IshchiDto ishchiDto) {
        Ishchi ishchi=new Ishchi();
        ishchi.setIsmi(ishchiDto.getIsmi());
        ishchi.setTel(ishchiDto.getTel());
        Bolim bolim=new Bolim();
        bolim.setId(ishchiDto.getBolimId());
        ishchi.setBolim(bolim);
        Manzil mamzil=new Manzil();
        mamzil.setVil(ishchiDto.getVil());
        mamzil.setTum(ishchiDto.getTum());
        mamzil.setKocha(ishchiDto.getKocha());
        mamzil.setUy(ishchiDto.getUy());
        ishchi.setManzil(mamzil);
        manzilRepository.save(mamzil);
        ishchiRepository.save(ishchi);
        return new ApiResponse("Malumotlar saqlandi ",true);


    }


    public ApiResponse IshchiGet(Integer id) {
        Optional<Ishchi> byId = ishchiRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Bunday idli malumot topilmadi",false);
        return new ApiResponse(byId.toString(),true);


    }

    public ApiResponse ishchiGetId() {
        return new ApiResponse(ishchiRepository.findAll().toString(),true);


    }

    public ApiResponse IshchiPut(Integer id, IshchiDto ishchiDto) {
        Optional<Ishchi> byId = ishchiRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Bunday idli ishchi mavjud emas",false);
        Ishchi ishchi = byId.get();
        ishchi.setIsmi(ishchiDto.getIsmi());
        ishchi.setTel(ishchiDto.getTel());
        Manzil manzil = byId.get().getManzil();
        manzil.setVil(ishchiDto.getVil());
        manzil.setTum(ishchiDto.getTum());
        manzil.setKocha(ishchiDto.getKocha());
        manzil.setUy(ishchiDto.getUy());
        manzilRepository.save(manzil);
        ishchi.setManzil(manzil);
        ishchiRepository.save(ishchi);
        return new ApiResponse("Malumotlar tahrirlandi ",true);


    }

    public ApiResponse IshchiDelet(Integer id) {
        Optional<Ishchi> byId = ishchiRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Bunday idli malumot mavjud emas",false);
        ishchiRepository.deleteById(id);
        manzilRepository.deleteById(byId.get().getId());
        return new ApiResponse("Malumotlar ochirildi ",true);


    }
}

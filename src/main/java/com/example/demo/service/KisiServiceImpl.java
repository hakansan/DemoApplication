package com.example.demo.service;

import com.example.demo.exception.GenericException;
import com.example.demo.model.dto.KisiDTO;
import com.example.demo.model.entity.Kisi;
import com.example.demo.repository.KisiRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class KisiServiceImpl implements KisiService {

    @Autowired
    private KisiRespository kisiRespository;

    @Override
    public KisiDTO save(KisiDTO kisiDTO) {
        Kisi kisi = new Kisi();
        kisi.setAd(kisiDTO.getAd());
        kisi.setSoyad(kisiDTO.getSoyad());
        kisi.setTelefon(kisiDTO.getTelefon());
        final Kisi newKisi = kisiRespository.saveAndFlush(kisi);
        kisiDTO.setId(newKisi.getId());
        return kisiDTO;
    }

    @Override
    public List<KisiDTO> getAll() {
        List<Kisi> kisiList = kisiRespository.findAll();
        List<KisiDTO> kisiDTOS = new ArrayList<>();
        kisiList.forEach(kisi -> {
            KisiDTO kisiDTO = new KisiDTO();
            kisiDTO.setId(kisi.getId());
            kisiDTO.setAd(kisi.getAd());
            kisiDTO.setSoyad(kisi.getSoyad());
            kisiDTOS.add(kisiDTO);
        });
        return kisiDTOS;
    }

    @Override
    public KisiDTO update(KisiDTO kisiDTO) {
        Kisi newKisi = kisiRespository.findById(kisiDTO.getId())
                .orElseThrow(() -> new GenericException("Kisi bulunamadı ID: " + kisiDTO.getId()));
        newKisi.setAd(kisiDTO.getAd());
        newKisi.setSoyad(kisiDTO.getSoyad());
        newKisi.setTelefon(kisiDTO.getTelefon());
        return kisiDTO;
    }

    @Override
    public void delete(Long id) {
        kisiRespository.findById(id)
                .orElseThrow(() -> new GenericException("kişi bulunamadı! ID: " + id));
        kisiRespository.deleteById(id);
    }

    @Override
    public List<KisiDTO> findBySoyad(String soyad) {
        return null;
    }
}

package com.example.demo.service;

import com.example.demo.model.dto.KisiDTO;

import java.util.List;

public interface KisiService {

    //crud

    KisiDTO save(KisiDTO kisiDTO);

    List<KisiDTO> getAll();

    KisiDTO update(KisiDTO kisiDTO);

    void delete(Long id);

    List<KisiDTO> findBySoyad(String soyad);
}

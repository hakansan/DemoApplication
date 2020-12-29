package com.example.demo.service;

import com.example.demo.model.dto.AdresDTO;

import java.util.List;

public interface AdresService {

    AdresDTO save(AdresDTO adresDTO);

    List<AdresDTO> getAll();

    void update(AdresDTO adresDTO);

    void delete(Long id);

    List<AdresDTO> findBySoyad(String soyad);
}

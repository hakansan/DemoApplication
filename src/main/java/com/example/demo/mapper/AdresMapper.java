package com.example.demo.mapper;

import com.example.demo.model.dto.AdresDTO;
import com.example.demo.model.entity.Adres;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AdresMapper {
    AdresDTO toAdresDTO(Adres adres);
    Adres toAdres(AdresDTO adresDTO);
    List<AdresDTO> toAdresDTOList(List<Adres> adresList);
    List<Adres> toAdresList(List<AdresDTO> adresDTOList);

}

package com.example.demo.mapper;

import com.example.demo.model.dto.KisiDTO;
import com.example.demo.model.entity.Kisi;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface KisiMapper {
    KisiDTO toKisiDTO(Kisi kisi);
    Kisi toKisi(KisiDTO kisiDTO);
    List<KisiDTO> toKisiDTOList(List<Kisi> kisiList);
    List<Kisi> toKisiList(List<KisiDTO> kisiDTOList);

}

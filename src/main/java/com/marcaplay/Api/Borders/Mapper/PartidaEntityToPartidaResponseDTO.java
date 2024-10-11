package com.marcaplay.Api.Borders.Mapper;

import com.marcaplay.Api.Borders.Dtos.PartidaResponseDTO;
import com.marcaplay.Api.Borders.Entities.PartidaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartidaEntityToPartidaResponseDTO {
    PartidaResponseDTO partidaEntityToPartidaResponseDTO(PartidaEntity partidaEntity);
}

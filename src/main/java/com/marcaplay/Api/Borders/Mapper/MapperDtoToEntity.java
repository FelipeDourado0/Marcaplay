package com.marcaplay.Api.Borders.Mapper;

import com.marcaplay.Api.Borders.Dtos.AtletaRequestDTO;
import com.marcaplay.Api.Borders.Dtos.EnderecoRequestDTO;
import com.marcaplay.Api.Borders.Entities.AtletaEntity;
import com.marcaplay.Api.Borders.Entities.EnderecoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperDtoToEntity {
    //public EnderecoEntity requestToEnderecoEntity(EnderecoRequestDTO enderecoRequestDTO);

    public AtletaEntity atletaRequestDtoToEntity(AtletaRequestDTO atletaRequestDTO);

    public EnderecoEntity enderecoRequestDtoToEntity(EnderecoRequestDTO enderecoRequestDTO);
}

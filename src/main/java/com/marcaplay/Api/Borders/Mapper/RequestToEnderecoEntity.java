package com.marcaplay.Api.Borders.Mapper;

import com.marcaplay.Api.Borders.Dtos.EnderecoRequestDTO;
import com.marcaplay.Api.Borders.Entities.EnderecoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestToEnderecoEntity {

    public EnderecoEntity requestToEnderecoEntity(EnderecoRequestDTO enderecoRequestDTO);
}

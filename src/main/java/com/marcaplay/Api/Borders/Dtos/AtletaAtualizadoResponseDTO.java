package com.marcaplay.Api.Borders.Dtos;

import com.marcaplay.Api.Borders.Entities.AtletaEntity;
import com.marcaplay.Api.Borders.Entities.EnderecoEntity;

public record AtletaAtualizadoResponseDTO(AtletaEntity atletaEntity, EnderecoEntity enderecoEntity){}

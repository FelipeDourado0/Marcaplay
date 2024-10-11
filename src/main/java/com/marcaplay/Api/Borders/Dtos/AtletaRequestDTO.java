package com.marcaplay.Api.Borders.Dtos;

import com.marcaplay.Api.Borders.Entities.AtletaEntity;
import com.marcaplay.Api.Borders.Entities.EnderecoEntity;

public record AtletaRequestDTO(String nome,
        String email,
        String telefone,
        String cpf,
       EnderecoRequestDTO endereco) {
}

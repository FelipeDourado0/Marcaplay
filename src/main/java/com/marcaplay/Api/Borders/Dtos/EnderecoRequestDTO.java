package com.marcaplay.Api.Borders.Dtos;

public record EnderecoRequestDTO(
        String cep,
        String logradouro,
        String cidade,
        String complemento,
        String bairro,
        String estado,
        String uf,
        String ddd) {
}

package com.marcaplay.Api.Borders.Entities;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document()
public class EnderecoEntity {
    @Id
    private String id;

    private String cep;

    private String logradouro;

    private String cidade;

    private String complemento;

    private String bairro;

    private String estado;

    private String uf;

    private String ddd;
}

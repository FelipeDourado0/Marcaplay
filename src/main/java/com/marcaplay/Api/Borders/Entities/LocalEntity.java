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
public class LocalEntity {
    @Id
    private String id;
    private String nome;
    private String esporte;
    private String enderecoId;
}

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
public class PartidaAtletaEntity {
    @Id
    private String id;
    private String partidaId;
    private String atletaId;
}

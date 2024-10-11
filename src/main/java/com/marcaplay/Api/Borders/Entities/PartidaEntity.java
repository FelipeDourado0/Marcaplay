package com.marcaplay.Api.Borders.Entities;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document()
public class PartidaEntity {
    @Id
    private String id;
    private LocalDateTime dataHoraPartida;
    private int quantidadeJogadores;
    private LocalDateTime dataHoraCriacao;
    private String localId;
}

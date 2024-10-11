package com.marcaplay.Api.Borders.Dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcaplay.Api.Borders.Entities.LocalEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartidaResponseDTO {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataHoraPartida;

    private int quantidadeJogadores;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataHoraCriacao;

    private LocalEntity local;
}

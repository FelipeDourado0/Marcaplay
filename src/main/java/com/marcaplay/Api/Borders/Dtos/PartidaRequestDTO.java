package com.marcaplay.Api.Borders.Dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record PartidaRequestDTO(int quantidadeJogadores, LocalDateTime dataHoraPartida, String idLocal) {
}

package com.marcaplay.Api.controller;

import com.marcaplay.Api.Borders.Dtos.PartidaRequestDTO;
import com.marcaplay.Api.Borders.Dtos.PartidaResponseDTO;
import com.marcaplay.Api.Borders.Entities.PartidaEntity;
import com.marcaplay.Api.Service.PartidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partida")
public class PartidaController {

    @Autowired
    private PartidaService _partidaService;

    @PostMapping
    @Operation(summary = "Cria Partida", description = "Cria partidas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Falha ao cadastrar partida."),
            @ApiResponse(responseCode = "500",  description = "Dados enviados não estão corretos.")
    })
    public ResponseEntity<PartidaResponseDTO> create(@RequestBody PartidaRequestDTO partida) {

        PartidaResponseDTO newPartida = _partidaService.criarPartida(partida);
        return ResponseEntity.ok(newPartida);
    }

    @GetMapping
    @Operation(summary = "Obter lista de partidas", description = "Obter lista de partidas")
    public ResponseEntity<List<PartidaEntity>> getAll() {
        List<PartidaEntity> partidas = _partidaService.obterTodasPartidas();
        return ResponseEntity.ok(partidas);
    }
}

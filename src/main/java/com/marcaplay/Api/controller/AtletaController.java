package com.marcaplay.Api.controller;

import com.marcaplay.Api.Borders.Dtos.AtletaAtualizadoResponseDTO;
import com.marcaplay.Api.Borders.Dtos.AtletaRequestDTO;
import com.marcaplay.Api.Borders.Entities.AtletaEntity;
import com.marcaplay.Api.Repositories.AtletaRepository;
import com.marcaplay.Api.Service.AtletaService;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atleta")
public class AtletaController {

    @Autowired
    private AtletaService atletaService;

    @GetMapping("/{id}")
    public ResponseEntity<AtletaEntity> obterAtletaPorId(@PathVariable String id) {
        return ResponseEntity.ok(atletaService.obterAtletaPorId(id));
    }

    @PostMapping
    public ResponseEntity<AtletaEntity> criarAtleta(@RequestBody AtletaRequestDTO atleta) {
        return ResponseEntity.ok(atletaService.criarAtleta(atleta));
    }

    @PutMapping
    public ResponseEntity<AtletaAtualizadoResponseDTO> atualizarAtleta(@RequestBody AtletaRequestDTO atleta, @RequestParam String id) {
        return ResponseEntity.ok(atletaService.atualizarAtleta(atleta, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> atualizarAtleta(@PathVariable String id) {
        atletaService.deletarAtletaPorId(id);
        return ResponseEntity.ok("Atleta deletado com sucesso!");
    }

}

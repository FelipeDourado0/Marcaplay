package com.marcaplay.Api.controller;

import com.marcaplay.Api.Borders.Dtos.LocalRequestDTO;
import com.marcaplay.Api.Borders.Entities.LocalEntity;
import com.marcaplay.Api.Service.LocalService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/local")

public class LocalController {

    @Autowired
    private LocalService _localService;

    @PostMapping
    @Operation(summary = "Criar local", description = "Criar local")
    public ResponseEntity<LocalEntity> create(@RequestBody LocalRequestDTO local){

        LocalEntity newLcoal = _localService.criarLocal(local);
        return ResponseEntity.ok().body(newLcoal);
    }

    @GetMapping
    @Operation(summary = "Obter lista de Locais", description = "Obter lista de Locais")
    public ResponseEntity<List<LocalEntity>> getAll(){
        List<LocalEntity> todosLocal = _localService.ObterTodosLocal();
        return ResponseEntity.ok(todosLocal);
    }
}

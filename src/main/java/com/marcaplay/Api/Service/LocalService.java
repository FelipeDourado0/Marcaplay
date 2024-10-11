package com.marcaplay.Api.Service;

import com.marcaplay.Api.Borders.Dtos.LocalRequestDTO;
import com.marcaplay.Api.Borders.Entities.EnderecoEntity;
import com.marcaplay.Api.Borders.Entities.LocalEntity;
import com.marcaplay.Api.Repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private EnderecoService _enderecoService;

    public LocalEntity criarLocal(LocalRequestDTO data) {
        LocalEntity local = new LocalEntity();

        EnderecoEntity enderecoSalvo = _enderecoService.criarEndereco(data.endereco());
        local.setEnderecoId(enderecoSalvo.getId());
        local.setNome(data.nome());
        local.setEsporte(data.esporte());

        return localRepository.save(local);
    }

    public LocalEntity ObterLocal(String id){
        Optional<LocalEntity> local = localRepository.findById(id);
        return local.orElse(null);
    }

    public List<LocalEntity> ObterTodosLocal(){
        var local = localRepository.findAll();
        return local;
    }
}

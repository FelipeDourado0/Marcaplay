package com.marcaplay.Api.Service;

import com.marcaplay.Api.Borders.Dtos.PartidaRequestDTO;
import com.marcaplay.Api.Borders.Dtos.PartidaResponseDTO;
import com.marcaplay.Api.Borders.Entities.LocalEntity;
import com.marcaplay.Api.Borders.Entities.PartidaEntity;
import com.marcaplay.Api.Borders.Mapper.PartidaEntityToPartidaResponseDTO;
import com.marcaplay.Api.Repositories.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private LocalService _localService;

    @Autowired
    private PartidaEntityToPartidaResponseDTO _mapper;

    public PartidaResponseDTO criarPartida(PartidaRequestDTO data) {
        PartidaEntity partida = new PartidaEntity();

        partida.setDataHoraPartida(data.dataHoraPartida());
        partida.setDataHoraCriacao(LocalDateTime.now());
        partida.setQuantidadeJogadores(data.quantidadeJogadores());
        LocalEntity local = _localService.ObterLocal(data.idLocal());
        partida.setLocalId(local.getId());
        partidaRepository.save(partida);

        return _mapper.partidaEntityToPartidaResponseDTO(partida);
    }

    public List<PartidaEntity> obterTodasPartidas() {
        return partidaRepository.findAll();
    }

    public PartidaEntity obterPartidaPorId(String id){
        return partidaRepository.findById(id).orElse(null);
    }
}

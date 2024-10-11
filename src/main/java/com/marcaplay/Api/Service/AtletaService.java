package com.marcaplay.Api.Service;

import com.marcaplay.Api.Borders.Dtos.AtletaAtualizadoResponseDTO;
import com.marcaplay.Api.Borders.Dtos.AtletaRequestDTO;
import com.marcaplay.Api.Borders.Entities.AtletaEntity;
import com.marcaplay.Api.Borders.Entities.EnderecoEntity;
import com.marcaplay.Api.Borders.Mapper.MapperDtoToEntity;
import com.marcaplay.Api.Borders.Mapper.RequestToEnderecoEntity;
import com.marcaplay.Api.Borders.exceptions.BusinessException;
import com.marcaplay.Api.Repositories.AtletaRepository;
import com.marcaplay.Api.Repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtletaService {
    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private MapperDtoToEntity _mapperMapperDtoToEntity;

    @Autowired
    private RequestToEnderecoEntity requestToEnderecoEntity;

    public AtletaEntity criarAtleta(AtletaRequestDTO atleta) {
        try{
            var enderecoSalvo = enderecoService.criarEndereco(atleta.endereco());

            AtletaEntity atletaEntity = new AtletaEntity();
            atletaEntity.setEmail(atleta.email());
            atletaEntity.setNome(atleta.nome());
            atletaEntity.setCpf(atleta.cpf());
            atletaEntity.setTelefone(atleta.telefone());

            atletaEntity.setEnderecoId(enderecoSalvo.getId());

            return atletaRepository.save(atletaEntity);
        }catch (Exception e){
            throw new BusinessException("Erro ao criar um atleta");
        }
    }
    public AtletaAtualizadoResponseDTO atualizarAtleta(AtletaRequestDTO data, String atletaId) {
        try{

            AtletaEntity atletaAtual = atletaRepository.findById(atletaId).orElse(null);
            if(atletaAtual == null)
                throw new BusinessException("Erro ao atualizar um atleta");

            AtletaEntity atletaNovo = _mapperMapperDtoToEntity.atletaRequestDtoToEntity(data);
            atletaNovo.setId(atletaAtual.getId());
            atletaNovo.setEnderecoId(atletaAtual.getEnderecoId());
            atletaAtual = atletaNovo;
            var atletaAtualizado = atletaRepository.save(atletaAtual);

            EnderecoEntity enderecoAtual = enderecoService.obterEnderecoPorId(atletaAtual.getEnderecoId());
            if(enderecoAtual == null)
                throw new BusinessException("Erro ao atualizar o endereço");

            EnderecoEntity enderecoNovo = _mapperMapperDtoToEntity.enderecoRequestDtoToEntity(data.endereco());
            enderecoNovo.setId(enderecoAtual.getId());
            enderecoAtual = enderecoNovo;

            var enderecoAtualizado = enderecoService.atualizarEndereco(enderecoAtual);


            return new AtletaAtualizadoResponseDTO(atletaAtualizado, enderecoAtualizado);
        }catch (Exception e){
            throw new BusinessException("Erro ao atualizar um atleta");
        }
    }

    public void deletarAtletaPorId(String atletaId) {
        try{
            AtletaEntity atleta = atletaRepository.findById(atletaId).orElse(null);
            if(atleta != null){
                atletaRepository.deleteById(atletaId);
                enderecoService.deletarEnderecoPorId(atleta.getEnderecoId());
            }else{
                throw new BusinessException("Erro ao deletar um atleta");
            }
        }catch (Exception e){
            throw new BusinessException("Erro ao deletar um atleta");
        }
    }

    public AtletaEntity obterAtletaPorId(String atletaId) {
        return atletaRepository.findById(atletaId).orElse(null);
    }
}

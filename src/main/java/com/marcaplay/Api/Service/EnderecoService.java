package com.marcaplay.Api.Service;

import com.marcaplay.Api.Borders.Dtos.EnderecoRequestDTO;
import com.marcaplay.Api.Borders.Entities.EnderecoEntity;
import com.marcaplay.Api.Repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoEntity criarEndereco(EnderecoRequestDTO data) {

        EnderecoEntity newEndereco = new EnderecoEntity();
        newEndereco.setUf(data.uf());
        newEndereco.setCidade(data.cidade());
        newEndereco.setEstado(data.estado());
        newEndereco.setCep(data.cep());
        newEndereco.setBairro(data.bairro());
        newEndereco.setLogradouro(data.logradouro());
        newEndereco.setDdd(data.ddd());
        newEndereco.setComplemento(data.complemento());

        return enderecoRepository.save(newEndereco);
    }

    public void deletarEnderecoPorId(String enderecoId) {
        enderecoRepository.deleteById(enderecoId);
    }

    public EnderecoEntity obterEnderecoPorId(String enderecoId) {
        return enderecoRepository.findById(enderecoId).orElse(null);
    }

    public EnderecoEntity atualizarEndereco(EnderecoEntity endereco) {
        return enderecoRepository.save(endereco);
    }
}

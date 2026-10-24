package com.senai.projeto.service;

import com.senai.projeto.entity.ServicosEntity;
import com.senai.projeto.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosService {
    @Autowired
    private ServicosRepository repository;

    public List<ServicosEntity> listarTodos() {
        return repository.findAll();
    }

    public ServicosEntity salvarServicos(ServicosEntity servicos) {

        if (repository.findById(servicos.getId()).isPresent()) {
            throw new IllegalArgumentException("Serviço já existente.");
        }
        return repository.save(servicos);
    }

    public ServicosEntity atualizarServicos(Long id, ServicosEntity servico) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Serviço não encontrado.");

        servico.setId(id);
        return repository.save(servico);
    }

    public void excluirServico(Long id) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Serviço não encontrado.");

        repository.deleteById(id);
    }
}
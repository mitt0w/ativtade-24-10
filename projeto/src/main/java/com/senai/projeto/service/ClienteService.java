package com.senai.projeto.service;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<ClienteEntity> listarTodos() {
        return repository.findAll();
    }

    public ClienteEntity salvarCliente(ClienteEntity cliente) {

        if (repository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        return repository.save(cliente);
    }

    public ClienteEntity atualizarCliente(Long id, ClienteEntity cliente) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliente não encontrado.");

        cliente.setId(id);
        return repository.save(cliente);
    }

    public void excluirCliente(Long id) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliente não encontrado.");

        repository.deleteById(id);
    }
}
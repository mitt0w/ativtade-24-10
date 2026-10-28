package com.senai.projeto.service;

import com.senai.projeto.entity.FuncionarioEntity;
import com.senai.projeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioEntity> listarTodos() {
        return repository.findAll();
    }

    public FuncionarioEntity salvarFuncionario(FuncionarioEntity funcionario) {

        if (repository.findById(funcionario.getId()).isPresent()) {
            throw new IllegalArgumentException("Funcionário já cadastrado.");
        }
        return repository.save(funcionario);
    }

    public FuncionarioEntity atualizarFuncionario(Long id, FuncionarioEntity funcionario) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Funcionário não encontrado.");

        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public void excluirFuncionario(Long id) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Funcionário não encontrado.");

        repository.deleteById(id);
    }
}
package com.senai.projeto.service;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.entity.PetEntity;
import com.senai.projeto.repository.ClienteRepository;
import com.senai.projeto.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository repository;

    public List<PetEntity> listarTodos() {
        return repository.findAll();
    }

    public PetEntity salvarPet (PetEntity pet) {

        if (repository.findById(pet.getId()).isPresent()) {
            throw new IllegalArgumentException("Pet já cadastrado.");
        }
        return repository.save(pet);
    }

    public PetEntity atualizarPet(Long id, PetEntity pet) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Pet não encontrado.");

        pet.setId(id);
        return repository.save(pet);
    }

    public void excluirPet (Long id) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Pet não encontrado.");

        repository.deleteById(id);
    }
}
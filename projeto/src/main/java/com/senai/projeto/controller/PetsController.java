package com.senai.projeto.controller;

import com.senai.projeto.entity.PetsEntity;
import com.senai.projeto.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pets")
public class PetsController {
    @Autowired
    private PetsRepository repository;

    @GetMapping
    public List<PetsEntity> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody PetsEntity pet) {
        repository.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Pets cadastrados com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody PetsEntity pet) {
        pet.setId(id);
        repository.save(pet);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pets atualizados com sucesso!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pets excluídos com sucesso!"));
    }
}
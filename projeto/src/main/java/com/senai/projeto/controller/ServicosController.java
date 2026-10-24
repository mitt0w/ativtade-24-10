package com.senai.projeto.controller;

import com.senai.projeto.entity.ServicosEntity;
import com.senai.projeto.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/servicos")
public class ServicosController {
    @Autowired
    private ServicosRepository repository;

    @GetMapping
    public List<ServicosEntity> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody ServicosEntity servico) {
        repository.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Serviços cadastrados com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody ServicosEntity servico) {
        servico.setId(id);
        repository.save(servico);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Serviços atualizados com sucesso!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Serviços excluídos com sucesso!"));
    }
}
package com.senai.projeto.controller;

import com.senai.projeto.entity.FornecedoresEntity;
import com.senai.projeto.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {
    @Autowired
    private FornecedoresRepository repository;

    @GetMapping
    public List<FornecedoresEntity> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody FornecedoresEntity fornecedor) {
        repository.save(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Fornecedores cadastrados com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody FornecedoresEntity fornecedor) {
        fornecedor.setId(id);
        repository.save(fornecedor);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedores atualizados com sucesso!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedores excluídos com sucesso!"));
    }
}
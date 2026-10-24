package com.senai.projeto.controller;

import com.senai.projeto.entity.FuncionariosEntity;
import com.senai.projeto.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {
    @Autowired
    private FuncionariosRepository repository;

    @GetMapping
    public List<FuncionariosEntity> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody FuncionariosEntity funcionario) {
        repository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionários cadastrados com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody FuncionariosEntity funcionario) {
        funcionario.setId(id);
        repository.save(funcionario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionários atualizados com sucesso!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionários excluídos com sucesso!"));
    }
}
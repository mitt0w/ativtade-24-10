package com.senai.projeto.controller;

import com.senai.projeto.entity.ProdutosEntity;
import com.senai.projeto.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosRepository repository;

    @GetMapping
    public List<ProdutosEntity> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody ProdutosEntity produto) {
        repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Produtos cadastrados com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody ProdutosEntity produto) {
        produto.setId(id);
        repository.save(produto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Produtos atualizados com sucesso!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Produtos excluídos com sucesso!"));
    }
}
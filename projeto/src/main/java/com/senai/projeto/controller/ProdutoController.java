package com.senai.projeto.controller;

import com.senai.projeto.entity.ProdutoEntity;
import com.senai.projeto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoEntity> listar(){
        return service.listarTodos();
    }

    @PostMapping
    ResponseEntity<Map<String, String>> salvar(@RequestBody ProdutoEntity produto) {
        service.salvarProduto(produto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Produto cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody ProdutoEntity produto){
        service.atualizarProduto(id, produto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Produto atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String,  String>> excluir(@PathVariable Long id) {
        service.excluirProduto(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Produto excluído com sucesso!"));
    }
}
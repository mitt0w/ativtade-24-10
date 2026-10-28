package com.senai.projeto.controller;

import com.senai.projeto.entity.FornecedorEntity;
import com.senai.projeto.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @GetMapping
    public List<FornecedorEntity> listar(){
        return service.listarTodos();
    }

    @PostMapping
    ResponseEntity<Map<String, String>> salvar(@RequestBody FornecedorEntity fornecedor) {
        service.salvarFornecedor(fornecedor);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Fornecedor cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody FornecedorEntity fornecedor){
        service.atualizarFornecedor(id, fornecedor);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedor atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String,  String>> excluir(@PathVariable Long id) {
        service.excluirFornecedor(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedor excluído com sucesso!"));
    }
}
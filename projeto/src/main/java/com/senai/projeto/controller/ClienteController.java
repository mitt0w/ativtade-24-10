package com.senai.projeto.controller;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.repository.ClienteRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<ClienteEntity> listarTodos(){
        return repository.findAll();
 }

 @PostMapping
 public ResponseEntity<Map<String, String>> salvar(@RequestBody ClienteEntity cliente) {
     repository.save(cliente);
     return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(Map.of("mensagem", "Cliente cadastrado com sucesso!"));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Map<String, String>> atualizar(
         @PathVariable Long id,
         @RequestBody ClienteEntity cliente) {
     cliente.setId(id);
     repository.save(cliente);
     return ResponseEntity
             .status(HttpStatus.OK)
             .body(Map.of("mensagem", "Cliente atualizado com sucesso!"));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente excluído com sucesso!"));
    }
}
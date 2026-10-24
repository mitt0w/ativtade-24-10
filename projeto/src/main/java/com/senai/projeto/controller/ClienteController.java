package com.senai.projeto.controller;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.service.ClienteService;
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
    private ClienteService service;

    @GetMapping
    public List<ClienteEntity> listar(){
        return service.listarTodos();
    }

    @PostMapping
    ResponseEntity<Map<String, String>> salvar(@RequestBody ClienteEntity cliente) {
        service.salvarCliente(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cliente cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteEntity cliente){
        service.atualizarCliente(id, cliente);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String,  String>> excluir(@PathVariable Long id) {
        service.excluirCliente(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente excluído com sucesso!"));
    }

}

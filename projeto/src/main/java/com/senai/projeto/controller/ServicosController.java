package com.senai.projeto.controller;

import com.senai.projeto.entity.ServicosEntity;
import com.senai.projeto.service.ServicosService;
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
    private ServicosService service;

    @GetMapping
    public List<ServicosEntity> listar(){
        return service.listarTodos();
    }

    @PostMapping
    ResponseEntity<Map<String, String>> salvar(@RequestBody ServicosEntity servicos) {
        service.salvarServicos(servicos);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Serviço cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody ServicosEntity servicos){
        service.atualizarServicos(id, servicos);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Serviço atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String,  String>> excluir(@PathVariable Long id) {
        service.excluirServico(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Serviço excluído com sucesso!"));
    }
}
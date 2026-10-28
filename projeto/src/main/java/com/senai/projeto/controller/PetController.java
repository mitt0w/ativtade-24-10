package com.senai.projeto.controller;

import com.senai.projeto.entity.PetEntity;
import com.senai.projeto.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService service;

    @GetMapping
    public List<PetEntity> listar(){
        return service.listarTodos();
    }

    @PostMapping
    ResponseEntity<Map<String, String>> salvar(@RequestBody PetEntity pet) {
        service.salvarPet(pet);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Pet cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody PetEntity pet){
        service.atualizarPet(id, pet);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pet atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String,  String>> excluir(@PathVariable Long id) {
        service.excluirPet(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pet excluído com sucesso!"));
    }
}
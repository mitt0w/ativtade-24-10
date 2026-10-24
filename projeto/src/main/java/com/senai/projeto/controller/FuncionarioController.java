package com.senai.projeto.controller;

import com.senai.projeto.entity.FuncionarioEntity;
import com.senai.projeto.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class FuncionarioController {
    @RestController
    @RequestMapping("/funcionario")
    public class FuncionarioController {
        @Autowired
        private FuncionarioService service;

        @GetMapping
        public List<FuncionarioEntity> listar(){
            return service.listarTodos();
        }

        @PostMapping
        ResponseEntity<Map<String, String>> salvar(@RequestBody FuncionarioEntity funcionario) {
            service.salvarFuncionario(funcionario);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(Map.of("mensagem", "Funcionário cadastrado com sucesso"));
        }

        @PutMapping("/{id}")
        ResponseEntity<Map<String, String>> atualizar(
                @PathVariable Long id,
                @RequestBody FuncionarioEntity funcionario){
            service.atualizarFuncionario(id, funcionario);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of("mensagem", "Funcionário atualizado com sucesso."));
        }

        @DeleteMapping("/{id}")
        ResponseEntity<Map<String,  String>> excluir(@PathVariable Long id) {
            service.excluirFuncionario(id);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of("mensagem", "Funcionário excluído com sucesso!"));
        }
    }
}

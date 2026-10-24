package com.senai.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Welcome {
    @GetMapping
    public String bemVindo() {
        return "Bem-vindo!";
    }

    @GetMapping("/dev")
    public String dev() {
        return "Desenvolvido por clrjs";
    }

    @GetMapping("/cursos")
    public String cursos () {
        return "<h1>Curso: Desenvolvimento de Sistemas</h1>";
    }
}
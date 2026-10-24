package com.senai.projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ClienteEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
}
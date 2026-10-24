package com.senai.projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_funcionario")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class FuncionarioEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cargo;
    private String email;
    private String dataAdmissao;
}

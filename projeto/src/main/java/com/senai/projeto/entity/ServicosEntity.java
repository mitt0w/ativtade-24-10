package com.senai.projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_servicos")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ServicosEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    private Integer preco;
    private Integer duracaoMinutos;
}

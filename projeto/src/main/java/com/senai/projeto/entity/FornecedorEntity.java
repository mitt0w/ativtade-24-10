package com.senai.projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_fornecedor")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class FornecedorEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String telefone;
}

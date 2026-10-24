package com.senai.projeto.repository;

import com.senai.projeto.entity.FuncionariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<FuncionariosEntity, Long> {
}
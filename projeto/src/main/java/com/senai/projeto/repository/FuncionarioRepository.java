package com.senai.projeto.repository;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
    Optional<FuncionarioEntity> findById(Long id);
}
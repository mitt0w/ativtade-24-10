package com.senai.projeto.repository;

import com.senai.projeto.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {
    Optional<FornecedorEntity> findById(Long id);
}
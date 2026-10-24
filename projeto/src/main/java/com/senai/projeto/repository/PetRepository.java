package com.senai.projeto.repository;

import com.senai.projeto.entity.FuncionarioEntity;
import com.senai.projeto.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    Optional<PetEntity> findByEmail(String email);
}
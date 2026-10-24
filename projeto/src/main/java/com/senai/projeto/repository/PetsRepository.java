package com.senai.projeto.repository;

import com.senai.projeto.entity.PetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<PetsEntity, Long> {
}
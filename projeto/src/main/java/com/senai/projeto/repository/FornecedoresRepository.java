package com.senai.projeto.repository;

import com.senai.projeto.entity.FornecedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedoresRepository extends JpaRepository<FornecedoresEntity, Long> {
}
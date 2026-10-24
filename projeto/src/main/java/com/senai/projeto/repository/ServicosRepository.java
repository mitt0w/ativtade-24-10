package com.senai.projeto.repository;

import com.senai.projeto.entity.ServicosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository extends JpaRepository<ServicosEntity, Long> {
}
package com.example.hogwarts.repository;

import com.example.hogwarts.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Long> {
}
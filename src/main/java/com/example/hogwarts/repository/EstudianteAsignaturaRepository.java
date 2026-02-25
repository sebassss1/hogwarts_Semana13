package com.example.hogwarts.repository;

import com.example.hogwarts.model.ClavePrimariaEstudianteAsignatura;
import com.example.hogwarts.model.EstudianteAsignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteAsignaturaRepository extends JpaRepository<EstudianteAsignatura, ClavePrimariaEstudianteAsignatura> {
}
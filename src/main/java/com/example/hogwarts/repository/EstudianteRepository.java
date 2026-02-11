package com.example.hogwarts.repository;

import com.example.hogwarts.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByApellido(String apellido);
    List<Estudiante> findByAnyoCurso(Integer anyoCurso);
}
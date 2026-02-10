package com.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    @JsonBackReference
    private Profesor profesor;

    @ManyToMany(mappedBy = "asignaturas")
    @JsonBackReference
    private List<Student> estudiantes;

    // getters y setters
}

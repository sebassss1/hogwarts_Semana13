package com.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "casa_id")
    @JsonBackReference
    private Casa casa;

    @OneToMany(mappedBy = "profesor")
    @JsonManagedReference
    private List<Asignatura> asignaturas;

    // getters y setters
}

package com.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;

    @OneToOne
    @JoinColumn(name = "estudiante_id")
    @JsonBackReference
    private Student estudiante;

    // getters y setters
}

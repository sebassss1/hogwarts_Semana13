package com.example.hogwarts.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Student> estudiantes;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Profesor> profesores;

    // getters y setters
}
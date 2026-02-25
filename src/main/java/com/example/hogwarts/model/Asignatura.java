package com.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "asignatura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Long id;

    private String nombre;

    private String aula;

    private Boolean obligatoria;

    @OneToMany(mappedBy = "asignatura")
    @JsonManagedReference
    private List<Profesor> profesores;

    @OneToMany(mappedBy = "asignatura")
    @JsonBackReference
    private List<EstudianteAsignatura> estudiantes;
}
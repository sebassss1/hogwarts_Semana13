package com.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estudiante_asignatura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteAsignatura {

    @EmbeddedId
    private ClavePrimariaEstudianteAsignatura id;

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("idAsignatura")
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    @Column(name = "calificacion")
    private Double calificacion;
}
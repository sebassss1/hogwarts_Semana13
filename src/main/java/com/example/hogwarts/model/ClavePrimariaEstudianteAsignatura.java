package com.example.hogwarts.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClavePrimariaEstudianteAsignatura implements Serializable {

    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(name = "id_asignatura")
    private Long idAsignatura;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClavePrimariaEstudianteAsignatura)) return false;
        ClavePrimariaEstudianteAsignatura that = (ClavePrimariaEstudianteAsignatura) o;
        return Objects.equals(idEstudiante, that.idEstudiante) &&
                Objects.equals(idAsignatura, that.idAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, idAsignatura);
    }
}
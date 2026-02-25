package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.AsignaturaDTO;
import com.example.hogwarts.model.Asignatura;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {

    public AsignaturaDTO toDTO(Asignatura a) {
        if (a == null)
            return null;

        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(a.getId());
        dto.setNombre(a.getNombre());
        dto.setAula(a.getAula());
        dto.setObligatoria(a.getObligatoria());

        if (a.getProfesores() != null && !a.getProfesores().isEmpty()) {
            dto.setProfesor(a.getProfesores().stream()
                    .map(p -> p.getNombre() + " " + p.getApellido())
                    .collect(java.util.stream.Collectors.joining(", ")));
        }

        return dto;
    }
}

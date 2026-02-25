package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.ProfesorDTO;
import com.example.hogwarts.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {

    public ProfesorDTO toDTO(Profesor p) {
        if (p == null)
            return null;

        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre() + " " + p.getApellido());
        dto.setFechaInicio(p.getFechaInicio());

        if (p.getAsignatura() != null) {
            dto.setAsignatura(p.getAsignatura().getNombre());
        }

        return dto;
    }
}

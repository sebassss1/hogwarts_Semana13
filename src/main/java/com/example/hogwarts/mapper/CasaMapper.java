package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.CasaDTO;
import com.example.hogwarts.dto.ProfesorDTO;
import com.example.hogwarts.model.Casa;
import com.example.hogwarts.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CasaMapper {
    private final ProfesorMapper profesorMapper;

    public CasaMapper(ProfesorMapper profesorMapper) {
        this.profesorMapper = profesorMapper;
    }

    public CasaDTO toDTO(Casa casa) {
        if (casa == null)
            return null;

        CasaDTO dto = new CasaDTO();
        dto.setId(casa.getId());
        dto.setNombre(casa.getNombre());
        dto.setFundador(casa.getFundador());
        dto.setFantasma(casa.getFantasma());

        // Jefe de la casa (Profesor)
        if (casa.getJefe() != null) {
            dto.setJefe(profesorMapper.toDTO(casa.getJefe()));
        }

        // Estudiantes (Lista de nombres)
        if (casa.getEstudiantes() != null) {
            dto.setEstudiantes(casa.getEstudiantes().stream()
                    .map(e -> e.getNombre() + " " + e.getApellido())
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}

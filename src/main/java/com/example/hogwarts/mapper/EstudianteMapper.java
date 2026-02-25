package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.*;
import com.example.hogwarts.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EstudianteMapper {

    private final MascotaMapper mascotaMapper;

    public EstudianteMapper(MascotaMapper mascotaMapper) {
        this.mascotaMapper = mascotaMapper;
    }

    public EstudianteDTO toDTO(Estudiante s) {
        if (s == null)
            return null;
        EstudianteDTO dto = new EstudianteDTO();

        dto.setId(s.getIdEstudiante());
        dto.setNombre(s.getNombre() + " " + s.getApellido());
        dto.setAnyoCurso(s.getAnyoCurso());
        dto.setFechaNacimiento(s.getFechaNacimiento());
        dto.setCasa(s.getCasa() != null ? s.getCasa().getNombre() : null);

        if (s.getMascota() != null) {
            MascotaDTO mascotaDTO = new MascotaDTO();
            mascotaDTO.setId(s.getMascota().getId());
            mascotaDTO.setNombre(s.getMascota().getNombre());
            mascotaDTO.setEspecie(s.getMascota().getEspecie());
            mascotaDTO.setEstudiante(dto.getNombre());
            dto.setMascota(mascotaDTO);
        }

        if (s.getAsignaturas() != null) {
            dto.setAsignaturas(
                    s.getAsignaturas().stream()
                            .map(ea -> {
                                AsignaturaCalificacionDTO ac = new AsignaturaCalificacionDTO();
                                ac.setAsignatura(ea.getAsignatura().getNombre());
                                ac.setCalificacion(ea.getCalificacion());
                                return ac;
                            })
                            .collect(Collectors.toList()));
        }

        return dto;
    }

    public Estudiante toEntity(EstudianteCreateDTO dto) {
        if (dto == null)
            return null;

        Estudiante s = new Estudiante();
        s.setNombre(dto.getNombre());
        s.setApellido(dto.getApellido());
        s.setAnyoCurso(dto.getAnyoCurso());
        s.setFechaNacimiento(dto.getFechaNacimiento());
        if (dto.getMascota() != null) {
            s.setMascota(mascotaMapper.toEntity(dto.getMascota()));
            s.getMascota().setEstudiante(s);
        }
        return s;
    }

    public void updateEntityFromDTO(EstudianteUpdateDTO dto, Estudiante entity) {
        if (dto == null || entity == null)
            return;
        if (dto.getAnyoCurso() != null) {
            entity.setAnyoCurso(dto.getAnyoCurso());
        }
        if (dto.getFechaNacimiento() != null) {
            entity.setFechaNacimiento(dto.getFechaNacimiento());
        }
    }
}
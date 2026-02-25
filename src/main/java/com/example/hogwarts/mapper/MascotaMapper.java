package com.example.hogwarts.mapper;

import com.example.hogwarts.dto.MascotaCreateDTO;
import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.model.Mascota;
import org.springframework.stereotype.Component;

@Component
public class MascotaMapper {

    public MascotaDTO toDTO(Mascota m) {
        if (m == null)
            return null;

        MascotaDTO dto = new MascotaDTO();
        dto.setId(m.getId());
        dto.setNombre(m.getNombre());
        dto.setEspecie(m.getEspecie());
        if (m.getEstudiante() != null) {
            dto.setEstudiante(m.getEstudiante().getNombre() + " " + m.getEstudiante().getApellido());
        }
        return dto;
    }

    public Mascota toEntity(MascotaCreateDTO dto) {
        if (dto == null)
            return null;
        Mascota m = new Mascota();
        m.setNombre(dto.getNombre());
        m.setEspecie(dto.getEspecie());
        return m;
    }
}

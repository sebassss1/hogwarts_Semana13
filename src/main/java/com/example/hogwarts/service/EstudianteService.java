package com.example.hogwarts.service;

import com.example.hogwarts.dto.EstudianteCreateDTO;
import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.dto.EstudianteUpdateDTO;
import com.example.hogwarts.mapper.EstudianteMapper;
import com.example.hogwarts.mapper.MascotaMapper;
import com.example.hogwarts.model.Casa;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.model.Mascota;
import com.example.hogwarts.repository.CasaRepository;
import com.example.hogwarts.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private final EstudianteRepository repo;
    private final CasaRepository casaRepo;
    private final EstudianteMapper mapper;
    private final MascotaMapper mascotaMapper;

    public EstudianteService(EstudianteRepository repo, CasaRepository casaRepo, EstudianteMapper mapper,
            MascotaMapper mascotaMapper) {
        this.repo = repo;
        this.casaRepo = casaRepo;
        this.mapper = mapper;
        this.mascotaMapper = mascotaMapper;
    }

    // LISTAR TODOS (DTO)
    public List<EstudianteDTO> getAllDTO() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // BUSCAR POR ID (DTO)
    public Optional<EstudianteDTO> getByIdDTO(Long id) {
        return repo.findById(id)
                .map(mapper::toDTO);
    }

    // CREAR (DESDE DTO)
    @Transactional
    public EstudianteDTO createFromDTO(EstudianteCreateDTO dto) {
        Estudiante s = mapper.toEntity(dto);

        // Asociar Casa
        if (dto.getCasaId() != null) {
            Casa casa = casaRepo.findById(dto.getCasaId())
                    .orElseThrow(() -> new RuntimeException("Casa no encontrada con ID: " + dto.getCasaId()));
            s.setCasa(casa);
        }

        Estudiante saved = repo.save(s);
        return mapper.toDTO(saved);
    }

    // ACTUALIZAR (DESDE DTO)
    @Transactional
    public Optional<EstudianteDTO> updateFromDTO(Long id, EstudianteUpdateDTO dto) {
        return repo.findById(id).map(existing -> {
            // Actualiza curso y fecha nacimiento (el mapper ignora nombre/apellido)
            mapper.updateEntityFromDTO(dto, existing);

            // Lógica compleja de Mascota (Requisito Semana 14)
            if (dto.getMascota() == null) {
                // "Si el estudiante tenía mascota, esta debe eliminarse."
                existing.setMascota(null);
            } else {
                // "Si el estudiante ya tenía mascota, debe reemplazarse por la nueva."
                // "Si no tenía mascota, ahora sí la tendrá."
                if (existing.getMascota() != null) {
                    // Reemplazo campos de la existente
                    existing.getMascota().setNombre(dto.getMascota().getNombre());
                    existing.getMascota().setEspecie(dto.getMascota().getEspecie());
                } else {
                    // Creación de una nueva
                    Mascota nuevaMascota = mascotaMapper.toEntity(dto.getMascota());
                    nuevaMascota.setEstudiante(existing);
                    existing.setMascota(nuevaMascota);
                }
            }

            return mapper.toDTO(repo.save(existing));
        });
    }

    // ELIMINAR
    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
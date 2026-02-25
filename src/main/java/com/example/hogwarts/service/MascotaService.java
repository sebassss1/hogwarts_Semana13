package com.example.hogwarts.service;

import com.example.hogwarts.dto.MascotaCreateStandaloneDTO;
import com.example.hogwarts.dto.MascotaDTO;
import com.example.hogwarts.mapper.MascotaMapper;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.model.Mascota;
import com.example.hogwarts.repository.EstudianteRepository;
import com.example.hogwarts.repository.MascotaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MascotaService {

    private final MascotaRepository repo;
    private final EstudianteRepository studentRepo;
    private final MascotaMapper mapper;

    public MascotaService(MascotaRepository repo, EstudianteRepository studentRepo, MascotaMapper mapper) {
        this.repo = repo;
        this.studentRepo = studentRepo;
        this.mapper = mapper;
    }

    public List<MascotaDTO> getAllDTO() {
        return repo.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MascotaDTO> getByIdDTO(Long id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    @Transactional
    public MascotaDTO createFromDTO(MascotaCreateStandaloneDTO dto) {
        Estudiante student = studentRepo.findById(dto.getEstudianteId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        // Si ya tiene mascota, la desvinculamos (orphanRemoval se encargará de
        // borrarla)
        if (student.getMascota() != null) {
            student.setMascota(null);
        }

        Mascota m = new Mascota();
        m.setNombre(dto.getNombre());
        m.setEspecie(dto.getEspecie());
        m.setEstudiante(student);
        student.setMascota(m);

        return mapper.toDTO(repo.save(m));
    }
}

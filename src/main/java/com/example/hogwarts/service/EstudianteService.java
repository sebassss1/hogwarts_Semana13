package com.example.hogwarts.service;

import com.example.hogwarts.dto.EstudianteDTO;
import com.example.hogwarts.mapper.EstudianteMapper;
import com.example.hogwarts.model.Estudiante;
import com.example.hogwarts.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private final EstudianteRepository repo;
    private final EstudianteMapper mapper;

    public EstudianteService(EstudianteRepository repo, EstudianteMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    // MÉTODOS QUE DEVUELVEN ENTIDADES (CRUD)

    public List<Estudiante> getAll() {
        return repo.findAll();
    }

    public Optional<Estudiante> getById(Long id) {
        return repo.findById(id);
    }

    public Estudiante create(Estudiante s) {
        return repo.save(s);
    }

    public Optional<Estudiante> update(Long id, Estudiante s) {
        return repo.findById(id).map(existing -> {
            existing.setNombre(s.getNombre());
            existing.setApellido(s.getApellido());
            existing.setAnyoCurso(s.getAnyoCurso());
            existing.setFechaNacimiento(s.getFechaNacimiento());
            return repo.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    // METODOS PARA DTOs

    public List<EstudianteDTO> getAllDTO() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EstudianteDTO> getByIdDTO(Long id) {
        return repo.findById(id)
                .map(mapper::toDTO);
    }
}
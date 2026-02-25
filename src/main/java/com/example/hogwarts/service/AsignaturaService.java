package com.example.hogwarts.service;

import com.example.hogwarts.dto.AsignaturaDTO;
import com.example.hogwarts.mapper.AsignaturaMapper;
import com.example.hogwarts.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repo;
    private final AsignaturaMapper mapper;

    public AsignaturaService(AsignaturaRepository repo, AsignaturaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<AsignaturaDTO> getAllDTO() {
        return repo.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AsignaturaDTO> getByIdDTO(Long id) {
        return repo.findById(id).map(mapper::toDTO);
    }
}

package com.example.hogwarts.service;

import com.example.hogwarts.dto.ProfesorDTO;
import com.example.hogwarts.mapper.ProfesorMapper;
import com.example.hogwarts.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorService {

    private final ProfesorRepository repo;
    private final ProfesorMapper mapper;

    public ProfesorService(ProfesorRepository repo, ProfesorMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<ProfesorDTO> getAllDTO() {
        return repo.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProfesorDTO> getByIdDTO(Long id) {
        return repo.findById(id).map(mapper::toDTO);
    }
}

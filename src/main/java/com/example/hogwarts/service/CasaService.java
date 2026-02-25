package com.example.hogwarts.service;

import com.example.hogwarts.dto.CasaDTO;
import com.example.hogwarts.mapper.CasaMapper;
import com.example.hogwarts.model.Casa;
import com.example.hogwarts.repository.CasaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CasaService {

    private final CasaRepository repo;
    private final CasaMapper mapper;

    public CasaService(CasaRepository repo, CasaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<CasaDTO> getAllDTO() {
        return repo.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CasaDTO> getByIdDTO(Long id) {
        return repo.findById(id).map(mapper::toDTO);
    }
}

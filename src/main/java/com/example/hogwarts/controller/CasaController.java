package com.example.hogwarts.controller;

import com.example.hogwarts.model.Casa;
import com.example.hogwarts.repository.CasaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/casas")
public class CasaController {

    private final CasaRepository repo;

    public CasaController(CasaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Casa> getAll() {
        return repo.findAll();
    }
}
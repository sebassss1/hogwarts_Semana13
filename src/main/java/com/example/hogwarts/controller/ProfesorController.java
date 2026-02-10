package com.example.hogwarts.controller;

import com.example.hogwarts.model.Profesor;
import com.example.hogwarts.repository.ProfesorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/profesores")
public class ProfesorController {

    private final ProfesorRepository repo;

    public ProfesorController(ProfesorRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Profesor> getAll() {
        return repo.findAll();
    }
}
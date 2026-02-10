package com.example.hogwarts.controller;

import com.example.hogwarts.model.Asignatura;
import com.example.hogwarts.repository.AsignaturaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/asignaturas")
public class AsignaturaController {

    private final AsignaturaRepository repo;

    public AsignaturaController(AsignaturaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Asignatura> getAll() {
        return repo.findAll();
    }
}
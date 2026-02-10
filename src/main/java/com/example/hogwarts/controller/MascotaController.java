package com.example.hogwarts.controller;

import com.example.hogwarts.model.Mascota;
import com.example.hogwarts.repository.MascotaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/mascotas")
public class MascotaController {

    private final MascotaRepository repo;

    public MascotaController(MascotaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Mascota> getAll() {
        return repo.findAll();
    }
}
package com.example.hogwarts.controller;

import com.example.hogwarts.dto.ProfesorDTO;
import com.example.hogwarts.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postgres/profesores")
public class ProfesorController {

    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> getAll() {
        return ResponseEntity.ok(service.getAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> getById(@PathVariable Long id) {
        return service.getByIdDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
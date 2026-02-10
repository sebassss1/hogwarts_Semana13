package com.example.hogwarts.service;

import com.example.hogwarts.model.Student;
import com.example.hogwarts.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Optional<Student> getById(Long id) {
        return repo.findById(id);
    }

    public Student create(Student s) {
        return repo.save(s);
    }

    public Optional<Student> update(Long id, Student s) {
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
}
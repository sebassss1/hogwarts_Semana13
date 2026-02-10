package com.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "anyo_curso", nullable = false)
    private Integer anyoCurso;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    // 🔗 Relación ManyToOne con Casa
    @ManyToOne
    @JoinColumn(name = "casa_id")
    @JsonBackReference
    private Casa casa;

    // 🔗 Relación OneToOne con Mascota
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Mascota mascota;

    // 🔗 Relación ManyToMany con Asignatura
    @ManyToMany
    @JoinTable(
            name = "student_asignatura",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id")
    )
    @JsonManagedReference
    private List<Asignatura> asignaturas;
}
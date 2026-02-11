package com.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudiante {

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
    @JoinColumn(name = "id_casa")
    @JsonBackReference
    private Casa casa;

    // 🔗 Relación OneToOne con Mascota
    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Mascota mascota;

    // 🔗 Relación ManyToMany con Asignatura
    @ManyToMany
    @JoinTable(name = "estudiante_asignatura", joinColumns = @JoinColumn(name = "id_estudiante"), inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
    @JsonManagedReference
    private List<Asignatura> asignaturas;
}
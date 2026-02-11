package com.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "casa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Long id;

    private String nombre;

    private String fundador;

    private String fantasma;

    @OneToOne
    @JoinColumn(name = "id_jefe")
    private Profesor jefe;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Estudiante> estudiantes;

    // getters y setters
}
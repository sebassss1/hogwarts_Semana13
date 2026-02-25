package com.example.hogwarts.dto;


import java.time.LocalDate;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDTO {
    private Long id;
    private String nombre;
    private String asignatura;
    private LocalDate fechaInicio;

    // getters y setters
}
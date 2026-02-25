package com.example.hogwarts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MascotaCreateStandaloneDTO {
    @NotBlank(message = "El nombre de la mascota no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La especie de la mascota no puede estar vacía")
    private String especie;

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Long estudianteId;
}

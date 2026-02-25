package com.example.hogwarts.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteCreateDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Min(value = 1, message = "El año de curso debe ser al menos 1")
    @Max(value = 7, message = "El año de curso no puede ser mayor a 7")
    @NotNull(message = "El año de curso es obligatorio")
    private Integer anyoCurso;

    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El ID de la casa es obligatorio")
    private Long casaId;

    private MascotaCreateDTO mascota;
}

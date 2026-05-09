package com.barberia.ms_clientes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarberoDTO {

    private Long idDelBarbero;

    @NotBlank(message = "El nombre del barbero no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombreDelBarbero;

    @NotBlank(message = "La especialidad es obligatoria")
    @Size(min = 5, message = "La especialidad debe ser más descriptiva (mínimo 5 caracteres)")
    private String especialidadDelBarbero;

    @NotNull(message = "El estado de actividad es obligatorio")
    private Boolean estaActivo;
}

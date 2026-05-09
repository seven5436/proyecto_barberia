

package com.barberia.ms_clientes.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDTO {

    private Long idDeLaCita;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long idDelClienteQueAgenda;

    @NotNull(message = "El ID del barbero es obligatorio")
    private Long idDelBarberoAsignado;

    @NotNull(message = "El ID del servicio es obligatorio")
    private Long idDelServicioSolicitado;

    @NotNull(message = "La fecha de la cita no puede estar vacía")
    @FutureOrPresent(message = "La fecha de la cita debe ser hoy o en el futuro")
    private LocalDate fechaDeLaCita;

    @NotNull(message = "La hora de inicio es obligatoria")
    private LocalTime horaDeInicio;

    @NotBlank(message = "El estado de la cita no puede estar vacío")
    @Pattern(regexp = "^(PENDIENTE|CONFIRMADA|CANCELADA|FINALIZADA)$", 
    message = "El estado debe ser: PENDIENTE, CONFIRMADA, CANCELADA o FINALIZADA")
    //VALIDACION PATTERN AGREGADA POR LA IA, PENDIENTE A REVISAR.
    private String estadoDeLaCita;
}



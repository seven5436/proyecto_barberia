package com.barberia.ms_clientes.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDTO {

    private Long idCita;

    private String nombreBarbero;
    private String nombreCliente;

    private LocalDate fechaCita;
    private LocalTime horaInicio;
    private String estadoCita;
}
package com.barberia.ms_clientes.dto;

import lombok.Data;

@Data
public class BarberoDTO {
    private Long idBarbero;
    private String nombreBarbero;
    private String especialidad;
    private String telefonoBarbero;
    private Boolean estado;
}
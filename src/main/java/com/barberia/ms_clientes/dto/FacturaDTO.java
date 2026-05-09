package com.barberia.ms_clientes.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaDTO {

    private Long idDeLaFactura;

    @NotNull(message = "El ID de la cita es obligatorio")
    private Long idDeLaCitaFacturada;

    @NotNull(message = "El monto total no puede ser nulo")
    @Positive(message = "El monto total cobrado debe ser mayor a cero")
    private Double montoTotalCobrado;

    @NotBlank(message = "El método de pago es obligatorio")
    @Pattern(regexp = "^(Efectivo|Tarjeta|Transferencia)$", 
    message = "El método de pago debe ser: Efectivo, Tarjeta o Transferencia")
    private String metodoDePago;

    @NotNull(message = "La fecha y hora de emisión es obligatoria")
    @PastOrPresent(message = "La fecha de emisión no puede ser una fecha futura")
    private LocalDateTime fechaYHoraDeEmision;
}

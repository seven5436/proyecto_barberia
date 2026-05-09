package com.barberia.ms_clientes.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Long idDelCliente;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombreDelCliente;

    @NotBlank(message = "El apellido del cliente es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellidoDelCliente;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "Debe proporcionar un formato de correo electrónico válido")
    private String emailDelCliente;

    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(regexp = "^\\+?[0-9]{9,15}$", message = "El teléfono debe contener entre 9 y 15 dígitos numéricos")
    //PATERN AGREGADO POR LA IA, PENDIENTE A REVISAR.
    private String telefonoDelCliente;

    @NotNull(message = "La fecha de registro es obligatoria")
    @PastOrPresent(message = "La fecha de registro no puede ser una fecha futura")
    //PATERN AGREGADO POR LA IA, PENDIENTE A REVISAR.
    private LocalDate fechaRegistro;
}

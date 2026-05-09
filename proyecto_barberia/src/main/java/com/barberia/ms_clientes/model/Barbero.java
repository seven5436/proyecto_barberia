package com.barberia.ms_clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "barberos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Barbero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarbero;
    
    @NotBlank (message = "El nombre es obligatorio")
    @Size (min = 3, max = 50, message="El nombre debe tener más de 3 carácteres")
    @Column(nullable = false, length = 50)

    private String nombreBarbero;

    @NotBlank (message = "La especialidad es obligatoria")
    @Column(nullable = false, length = 50)

    private String especialidadBarbero;

    @NotBlank (message = "El número de teléfono es obligatorio")
    @Column(nullable = false, length = 50)

    private String telefonoBarbero;

}
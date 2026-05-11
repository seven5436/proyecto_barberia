package com.barberia.ms_clientes.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resenas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Resena {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeLaResena;

    private Long idDelClienteQueOpina;
    private Long idDelBarberoEvaluado;
    private Integer calificacionDeEstrellas;
    private String comentarioDelCliente;
    private LocalDate fechaDeLaResena;
}

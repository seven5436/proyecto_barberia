package com.barberia.ms_clientes.repository;

import com.barberia.ms_clientes.model.Cita;
import com.barberia.ms_clientes.model.Barbero;
import com.barberia.ms_clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {


    List<Cita> findByBarbero(Barbero barbero);


    List<Cita> findByCliente(Cliente cliente);


    List<Cita> findByBarberoAndFechaDeLaCita(Barbero barbero, LocalDate fecha);


    List<Cita> findByEstadoDeLaCita(String estado);

}
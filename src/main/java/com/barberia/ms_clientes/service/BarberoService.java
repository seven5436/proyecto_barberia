package com.barberia.ms_clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barberia.ms_clientes.model.Barbero;
import com.barberia.ms_clientes.repository.BarberoRepository;

@Service
public class BarberoService {
    @Autowired
    private BarberoRepository barberoRepository;

    public List<Barbero> listarTodos() {
        return barberoRepository.findAll();
    }

    public Barbero guardar(Barbero barbero) {

        return barberoRepository.save(barbero);
    }
}
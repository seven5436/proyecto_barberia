package com.barberia.ms_clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barberia.ms_clientes.model.Barbero;
import com.barberia.ms_clientes.service.BarberoService;

@RestController
@RequestMapping("/api/barberos")
public class BarberoController {
    @Autowired
    private BarberoService barberoService;

    @GetMapping
    public List<Barbero> getBarberos() {
        return barberoService.listarTodos();
    }

    @PostMapping
    public Barbero crearBarbero(@RequestBody Barbero barbero) {
        return barberoService.guardar(barbero);
    }
}
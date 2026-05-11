package com.barberia.ms_clientes.service;

import com.barberia.ms_clientes.dto.ResenaDTO;
import com.barberia.ms_clientes.model.Resena;
import com.barberia.ms_clientes.repository.ResenaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    public List<Resena> traerTodasLasResenas() {
        log.info("Consultando todas las reseñas registradas en el sistema");
        return resenaRepository.findAll();
    }

    public Resena traerResenaPorId(Long id) {
        log.info("Buscando reseña con ID: {}", id);
        return resenaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la reseña con el ID: " + id));
    }

    public Resena guardarNuevaResena(ResenaDTO datos) {
        log.info("Guardando nueva reseña del cliente ID: {} para el barbero ID: {}", 
        datos.getIdDelClienteQueOpina(), datos.getIdDelBarberoEvaluado());
        
        Resena nuevaResena = new Resena();
        nuevaResena.setIdDelClienteQueOpina(datos.getIdDelClienteQueOpina());
        nuevaResena.setIdDelBarberoEvaluado(datos.getIdDelBarberoEvaluado());
        nuevaResena.setCalificacionDeEstrellas(datos.getCalificacionDeEstrellas());
        nuevaResena.setComentarioDelCliente(datos.getComentarioDelCliente());
        nuevaResena.setFechaDeLaResena(datos.getFechaDeLaResena() != null ? 
        datos.getFechaDeLaResena() : LocalDate.now());
        
        return resenaRepository.save(nuevaResena);
    }

    public void eliminarResena(Long id) {
        log.info("Eliminando reseña con ID: {}", id);
        traerResenaPorId(id); 
        resenaRepository.deleteById(id);
    }

    public ResenaDTO convertirAResenaDTO(Resena resena) {
        return ResenaDTO.builder()
                .idDeLaResena(resena.getIdDeLaResena())
                .idDelClienteQueOpina(resena.getIdDelClienteQueOpina())
                .idDelBarberoEvaluado(resena.getIdDelBarberoEvaluado())
                .calificacionDeEstrellas(resena.getCalificacionDeEstrellas())
                .comentarioDelCliente(resena.getComentarioDelCliente())
                .fechaDeLaResena(resena.getFechaDeLaResena())
                .build();
    }
}

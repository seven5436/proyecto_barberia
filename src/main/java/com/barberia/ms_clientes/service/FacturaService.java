package com.barberia.ms_clientes.service;

import com.barberia.ms_clientes.dto.FacturaDTO;
import com.barberia.ms_clientes.model.Cita;
import com.barberia.ms_clientes.model.Factura;
import com.barberia.ms_clientes.repository.CitaRepository;
import com.barberia.ms_clientes.repository.FacturaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@Slf4j
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private CitaRepository citaRepository;

    public FacturaDTO generarFactura(Long idCita, Double monto, String metodo) {
        log.info("Generando factura para la cita: {}", idCita);

        Cita cita = citaRepository.findById(idCita)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        if (facturaRepository.findByCitaIdCita(idCita).isPresent()) {
            throw new RuntimeException("Esta cita ya fue facturada anteriormente");
        }

        Factura factura = new Factura();
        factura.setCita(cita);
        factura.setMontoTotal(monto);
        factura.setMetodoDePago(metodo);
        factura.setFechaEmision(LocalDateTime.now());

        return convertirADTO(facturaRepository.save(factura));
    }

    private FacturaDTO convertirADTO(Factura factura) {
        FacturaDTO dto = new FacturaDTO();
        dto.setIdFactura(factura.getIdFactura());
        dto.setIdCita(factura.getCita().getIdCita());
        dto.setMontoTotal(factura.getMontoTotal());
        dto.setMetodoDePago(factura.getMetodoDePago());
        dto.setFechaEmision(factura.getFechaEmision());
        
        dto.setNombreCliente(factura.getCita().getCliente().getNombreCliente());
        dto.setNombreBarbero(factura.getCita().getBarbero().getNombreBarbero());
        return dto;
    }
}
package com.barberia.ms_clientes.repository;

import com.barberia.ms_clientes.model.Factura;
import com.barberia.ms_clientes.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    Optional<Factura> findByCita(Cita cita);

    List<Factura> findByMetodoDePago(String metodoDePago);

    List<Factura> findByFechaYHoraDeEmisionBetween(LocalDateTime inicio, LocalDateTime fin);

    boolean existsByCitaIdDeLaCita(Long idCita);
}


/* package com.barberia.ms_clientes.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeLaFactura;

    @OneToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    private Double montoTotalCobrado;
    private String metodoDePago;
    private LocalDateTime fechaYHoraDeEmision;
} */
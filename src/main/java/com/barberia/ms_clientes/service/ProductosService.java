package com.barberia.ms_clientes.service;

import com.barberia.ms_clientes.dto.ProductosDTO;
import com.barberia.ms_clientes.model.Productos;
import com.barberia.ms_clientes.repository.ProductosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductosService {

    @Autowired
    private ProductosRepository repo;

    public List<Productos> traerTodos() {
        log.info("buscando todos los productos por sucursal");
        return repo.findAll();
    }

    public Productos traerPorId(Long id) {
        log.info("buscando producto por sucursal con id: {}", id);
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("no existe el producto con id: " + id));
    }

    public Productos guardar(ProductosDTO datos) {
        log.info("guardando nuevo producto por sucursal");
        Productos nuevo = new Productos();
        nuevo.setIdSucursal(datos.getIdSucursal());
        nuevo.setIdProducto(datos.getIdProducto());
        nuevo.setStock(datos.getStock());
        return repo.save(nuevo);
    }

    public Productos actualizar(Long id, ProductosDTO datos) {
        log.info("actualizando producto por sucursal con id: {}", id);
        Productos producto = traerPorId(id);
        producto.setIdSucursal(datos.getIdSucursal());
        producto.setIdProducto(datos.getIdProducto());
        producto.setStock(datos.getStock());
        return repo.save(producto);
    }

    public void eliminar(Long id) {
        log.info("eliminando producto por sucursal con id: {}", id);
        traerPorId(id);
        repo.deleteById(id);
    }
}

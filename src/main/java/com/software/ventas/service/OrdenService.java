package com.software.ventas.service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.software.ventas.entity.Orden;
import com.software.ventas.repository.OrdenRepository;
import com.software.ventas.entity.Carrito;

/**
 * Service class for managing {@link Orden} entities.
 * This class provides methods for CRUD operations and managing orders associated with shopping carts.
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #findAll()}: Retrieves all orders.</li>
 *   <li>{@link #findById(Long)}: Retrieves an order by its ID.</li>
 *   <li>{@link #findByClienteId(Long)}: Retrieves a list of orders associated with a specific client ID.</li>
 *   <li>{@link #findByFechas(LocalDate, LocalDate)}: Retrieves a list of orders within a specified date range.</li>
 *   <li>{@link #create(Long)}: Creates a new order based on the specified shopping cart ID, which must be marked as purchased.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be automatically injected by Spring.</li>
 *   <li>{@link Lazy}: Indicates that the dependent bean should be lazily initialized.</li>
 *   <li>{@link Service}: Indicates that this class is a service component in Spring.</li>
 * </ul>
 * 
 * @see Orden
 * @see OrdenRepository
 * @see Carrito
 * @see CarritoService
 * 
 * Clase de servicio para gestionar entidades {@link Orden}.
 * Esta clase proporciona métodos para operaciones CRUD y gestión de órdenes asociadas con carritos de compras.
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>{@link #findAll()}: Recupera todas las órdenes.</li>
 *   <li>{@link #findById(Long)}: Recupera una orden por su ID.</li>
 *   <li>{@link #findByClienteId(Long)}: Recupera una lista de órdenes asociadas con un ID de cliente específico.</li>
 *   <li>{@link #findByFechas(LocalDate, LocalDate)}: Recupera una lista de órdenes dentro de un rango de fechas especificado.</li>
 *   <li>{@link #create(Long)}: Crea una nueva orden basada en el ID del carrito de compras especificado, que debe estar marcado como comprado.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link Lazy}: Indica que el bean dependiente debe ser inicializado de manera perezosa.</li>
 *   <li>{@link Service}: Indica que esta clase es un componente de servicio en Spring.</li>
 * </ul>
 * 
 * @see Orden
 * @see OrdenRepository
 * @see Carrito
 * @see CarritoService
 */


@Service
public class OrdenService {

    @Autowired
    OrdenRepository ordenRepository;

    @Autowired
    @Lazy
    CarritoService carritoService;
    
    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    public  Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

    public List<Orden> findByClienteId(Long clienteId) {
        return ordenRepository.findByClienteId(clienteId);
    }

    public List<Orden> findByFechas(LocalDate fecha_inicio, LocalDate fecha_fin) {
        return ordenRepository.findByFecha(fecha_inicio, fecha_fin);
    }

    public Orden create(Long carrito_id) {
        Carrito carrito = carritoService.findById(carrito_id).orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));
        if (!carrito.getComprado()) {
            throw new IllegalArgumentException("El carrito debe estar marcado como comprado para crear una orden.");
        }
        Orden orden = new Orden(carrito);
        return ordenRepository.save(orden);
    }

}

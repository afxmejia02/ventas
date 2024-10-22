package com.software.ventas.controller;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.ventas.entity.Orden;
import com.software.ventas.service.OrdenService;

/**
 * Controller class to manage {@link Orden} entities.
 * This class handles HTTP requests related to orders and their operations.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /ordenes - Retrieves a list of all orders.</li>
 *   <li>{@link #findById(Long)}: GET /ordenes/{id} - Retrieves an order by its ID.</li>
 *   <li>{@link #findByCarritoId(Long)}: GET /ordenes/cliente/{clienteId} - Retrieves a list of orders by customer ID.</li>
 *   <li>{@link #findByFechas(LocalDate, LocalDate)}: GET /ordenes/fechas/{fechaInicio}/{fechaFin} - Retrieves a list of orders within a date range.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be injected automatically by Spring.</li>
 *   <li>{@link RestController}: Indicates that this class is a REST controller.</li>
 *   <li>{@link RequestMapping}: Specifies the base URI for all endpoints in this controller.</li>
 * </ul>
 * 
 * @see Orden
 * @see OrdenService
 */

/**
 * Clase de controlador para gestionar entidades {@link Orden}.
 * Esta clase maneja las solicitudes HTTP relacionadas con las órdenes y sus operaciones.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /ordenes - Recupera una lista de todas las órdenes.</li>
 *   <li>{@link #findById(Long)}: GET /ordenes/{id} - Recupera una orden por su ID.</li>
 *   <li>{@link #findByCarritoId(Long)}: GET /ordenes/cliente/{clienteId} - Recupera una lista de órdenes por ID del cliente.</li>
 *   <li>{@link #findByFechas(LocalDate, LocalDate)}: GET /ordenes/fechas/{fechaInicio}/{fechaFin} - Recupera una lista de órdenes dentro de un rango de fechas.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link RestController}: Indica que esta clase es un controlador REST.</li>
 *   <li>{@link RequestMapping}: Especifica la URI base para todos los endpoints en este controlador.</li>
 * </ul>
 * 
 * @see Orden
 * @see OrdenService
 */


@RestController
@RequestMapping("/ordenes")
public class OrdenController {
    
    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> findAll() {
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public Orden findById(@PathVariable Long id) {
        return ordenService.findById(id).get();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Orden> findByCarritoId(@PathVariable Long clienteId) {
        return ordenService.findByClienteId(clienteId);
    }

    @GetMapping("/fechas/{fechaInicio}/{fechaFin}")
    public List<Orden> findByFechas(@PathVariable LocalDate fechaInicio, @PathVariable LocalDate fechaFin) {
        return ordenService.findByFechas(fechaInicio, fechaFin);
    }

}

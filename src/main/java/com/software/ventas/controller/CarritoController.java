package com.software.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.ventas.entity.Carrito;
import com.software.ventas.service.CarritoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class to manage {@link Carrito} entities.
 * This class handles HTTP requests related to carts and their operations.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /carritos - Retrieves a list of all carts.</li>
 *   <li>{@link #findById(Long)}: GET /carritos/{id} - Retrieves a cart by its ID.</li>
 *   <li>{@link #findByClienteId(Long)}: GET /carritos/cliente/{clienteId} - Retrieves a list of carts by client ID.</li>
 *   <li>{@link #create(Long)}: POST /carritos/create - Creates a new cart for a client.</li>
 *   <li>{@link #update(Long, Long)}: PUT /carritos/update - Updates an existing cart with a new client ID.</li>
 *   <li>{@link #comprar(Long)}: PUT /carritos/comprar - Marks a cart as purchased.</li>
 *   <li>{@link #delete(Long)}: DELETE /carritos/delete/{id} - Deletes a cart by its ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be injected automatically by Spring.</li>
 *   <li>{@link RestController}: Indicates that this class is a REST controller.</li>
 *   <li>{@link RequestMapping}: Specifies the base URI for all endpoints in this controller.</li>
 * </ul>
 * 
 * @see Carrito
 * @see CarritoService
 */

/**
 * Clase de controlador para gestionar entidades {@link Carrito}.
 * Esta clase maneja las solicitudes HTTP relacionadas con los carritos y sus operaciones.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /carritos - Recupera una lista de todos los carritos.</li>
 *   <li>{@link #findById(Long)}: GET /carritos/{id} - Recupera un carrito por su ID.</li>
 *   <li>{@link #findByClienteId(Long)}: GET /carritos/cliente/{clienteId} - Recupera una lista de carritos por ID de cliente.</li>
 *   <li>{@link #create(Long)}: POST /carritos/create - Crea un nuevo carrito para un cliente.</li>
 *   <li>{@link #update(Long, Long)}: PUT /carritos/update - Actualiza un carrito existente con un nuevo ID de cliente.</li>
 *   <li>{@link #comprar(Long)}: PUT /carritos/comprar - Marca un carrito como comprado.</li>
 *   <li>{@link #delete(Long)}: DELETE /carritos/delete/{id} - Elimina un carrito por su ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link RestController}: Indica que esta clase es un controlador REST.</li>
 *   <li>{@link RequestMapping}: Especifica la URI base para todos los endpoints en este controlador.</li>
 * </ul>
 * 
 * @see Carrito
 * @see CarritoService
 */


@RestController
@RequestMapping("/carritos")
public class CarritoController {
    
    @Autowired
    private CarritoService carritoService;
    
    @GetMapping
    public List<Carrito> findAll() {
        return carritoService.findAll();
    }

    @GetMapping("/{id}")
    public Carrito findById(@PathVariable Long id) {
        return carritoService.findById(id).get();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Carrito> findByClienteId(@PathVariable Long clienteId) {
        return carritoService.findByClienteId(clienteId);
    }

    @PostMapping("/create")
    public Carrito create(@RequestParam Long cliente_id) {
        return carritoService.create(cliente_id);
    }

    @PutMapping("/update")
    public Carrito update(@RequestParam Long id, @RequestParam Long cliente_id) {
        return carritoService.update(id, cliente_id);
    }

    @PutMapping("/comprar")
    public void comprar(@RequestParam Long id) {
        carritoService.comprar(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        carritoService.delete(id);
    }
    
}

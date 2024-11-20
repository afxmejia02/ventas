package com.software.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.software.ventas.entity.Item;
import com.software.ventas.service.ItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Controller class to manage {@link Item} entities.
 * This class handles HTTP requests related to items and their operations.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /items - Retrieves a list of all items.</li>
 *   <li>{@link #findById(Long)}: GET /items/{id} - Retrieves an item by its ID.</li>
 *   <li>{@link #findByCarritoId(Long)}: GET /items/carrito/{carritoId} - Retrieves a list of items by cart ID.</li>
 *   <li>{@link #findByProductoId(Long)}: GET /items/producto/{productoId} - Retrieves a list of items by product ID.</li>
 *   <li>{@link #create(Integer, Long, Long)}: POST /items/create - Creates a new item.</li>
 *   <li>{@link #update(Long, Integer, Long, Long)}: PUT /items/update/{id} - Updates an existing item by ID.</li>
 *   <li>{@link #delete(Long)}: DELETE /items/delete/{id} - Deletes an item by ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be injected automatically by Spring.</li>
 *   <li>{@link RestController}: Indicates that this class is a REST controller.</li>
 *   <li>{@link RequestMapping}: Specifies the base URI for all endpoints in this controller.</li>
 * </ul>
 * 
 * @see Item
 * @see ItemService
 */

/**
 * Clase de controlador para gestionar entidades {@link Item}.
 * Esta clase maneja las solicitudes HTTP relacionadas con los ítems y sus operaciones.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /items - Recupera una lista de todos los ítems.</li>
 *   <li>{@link #findById(Long)}: GET /items/{id} - Recupera un ítem por su ID.</li>
 *   <li>{@link #findByCarritoId(Long)}: GET /items/carrito/{carritoId} - Recupera una lista de ítems por ID del carrito.</li>
 *   <li>{@link #findByProductoId(Long)}: GET /items/producto/{productoId} - Recupera una lista de ítems por ID del producto.</li>
 *   <li>{@link #create(Integer, Long, Long)}: POST /items/create - Crea un nuevo ítem.</li>
 *   <li>{@link #update(Long, Integer, Long, Long)}: PUT /items/update/{id} - Actualiza un ítem existente por ID.</li>
 *   <li>{@link #delete(Long)}: DELETE /items/delete/{id} - Elimina un ítem por ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link RestController}: Indica que esta clase es un controlador REST.</li>
 *   <li>{@link RequestMapping}: Especifica la URI base para todos los endpoints en este controlador.</li>
 * </ul>
 * 
 * @see Item
 * @see ItemService
 */


@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Long id) {
        return itemService.findById(id).get();
    }

    @GetMapping("/carrito/{carritoId}")
    public List<Item> findByCarritoId(@PathVariable Long carritoId) {
        return itemService.findByCarritoId(carritoId);
    }

    @GetMapping("/carrito/comprado/{carritoComprado}")
    public List<Item> findByCarritoComprado(@PathVariable Boolean carritoComprado) {
        return itemService.findByCarritoComprado(carritoComprado);
    }

    @GetMapping("/producto/{productoId}")
    public List<Item> findByProductoId(@PathVariable Long productoId) {
        return itemService.findByProductoId(productoId);
    }

    @PostMapping("/create")
    public Item create(@RequestParam Integer unidades, @RequestParam Long producto_id, @RequestParam Long carrito_id)  {
        return itemService.create(unidades, producto_id, carrito_id);
    }

    @PutMapping("/update/{id}")
    public Item update(@PathVariable Long id, @RequestParam Integer unidades, @RequestParam Long producto_id, @RequestParam Long carrito_id) {
        return itemService.update(id, unidades, producto_id, carrito_id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        itemService.delete(id);
    }
        
}

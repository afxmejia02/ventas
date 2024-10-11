package com.software.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.ventas.entity.Producto;
import com.software.ventas.service.ProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Controller class to manage {@link Producto} entities.
 * This class handles HTTP requests related to products and their operations.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /productos - Retrieves a list of all products.</li>
 *   <li>{@link #findById(Long)}: GET /productos/{id} - Retrieves a product by its ID.</li>
 *   <li>{@link #findByNombre(String)}: GET /productos/nombre/{nombre} - Retrieves products by name.</li>
 *   <li>{@link #findByCategoria(String)}: GET /productos/categoria/{categoria} - Retrieves products by category.</li>
 *   <li>{@link #findByGenero(String)}: GET /productos/genero/{genero} - Retrieves products by gender.</li>
 *   <li>{@link #findByTalla(String)}: GET /productos/talla/{talla} - Retrieves products by size.</li>
 *   <li>{@link #create(Producto, String)}: POST /productos/create - Creates a new product.</li>
 *   <li>{@link #updateById(Long, Producto, String)}: PUT /productos/update/{id} - Updates a product by ID.</li>
 *   <li>{@link #deleteById(Long)}: DELETE /productos/delete/{id} - Deletes a product by ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be injected automatically by Spring.</li>
 *   <li>{@link RestController}: Indicates that this class is a REST controller.</li>
 *   <li>{@link RequestMapping}: Specifies the base URI for all endpoints in this controller.</li>
 * </ul>
 * 
 * @see Producto
 * @see ProductoService
 */

/**
 * Clase de controlador para gestionar entidades {@link Producto}.
 * Esta clase maneja las solicitudes HTTP relacionadas con los productos y sus operaciones.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /productos - Recupera una lista de todos los productos.</li>
 *   <li>{@link #findById(Long)}: GET /productos/{id} - Recupera un producto por su ID.</li>
 *   <li>{@link #findByNombre(String)}: GET /productos/nombre/{nombre} - Recupera productos por nombre.</li>
 *   <li>{@link #findByCategoria(String)}: GET /productos/categoria/{categoria} - Recupera productos por categoría.</li>
 *   <li>{@link #findByGenero(String)}: GET /productos/genero/{genero} - Recupera productos por género.</li>
 *   <li>{@link #findByTalla(String)}: GET /productos/talla/{talla} - Recupera productos por talla.</li>
 *   <li>{@link #create(Producto, String)}: POST /productos/create - Crea un nuevo producto.</li>
 *   <li>{@link #updateById(Long, Producto, String)}: PUT /productos/update/{id} - Actualiza un producto por ID.</li>
 *   <li>{@link #deleteById(Long)}: DELETE /productos/delete/{id} - Elimina un producto por ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link RestController}: Indica que esta clase es un controlador REST.</li>
 *   <li>{@link RequestMapping}: Especifica la URI base para todos los endpoints en este controlador.</li>
 * </ul>
 * 
 * @see Producto
 * @see ProductoService
 */


@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable Long id) {
        return productoService.findById(id).get();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Producto> findByNombre(@PathVariable String nombre) {
        return productoService.findByNombre(nombre);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> findByCategoria(@PathVariable String categoria) {
        return productoService.findByCategoria(categoria);
    }

    @GetMapping("/genero/{genero}")
    public List<Producto> findByGenero(@PathVariable String genero) {
        return productoService.findByGenero(genero);
    }

    @GetMapping("/talla/{talla}")
    public List<Producto> findByTalla(@PathVariable String talla) {
        return productoService.findByTalla(talla);
    }

    @PostMapping("/create")
    public Producto create(@RequestBody Producto producto, @RequestParam String talla) {
        return productoService.create(producto, talla);
    }

    @PutMapping("/update/{id}")
    public Producto updateById(@PathVariable Long id, @RequestBody Producto producto, @RequestParam String talla) {
        return productoService.updateById(id, producto, talla);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productoService.deleteById(id);
    }
   
}

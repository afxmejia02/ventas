package com.software.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.ventas.entity.Producto;
import com.software.ventas.entity.enums.Categoria;
import com.software.ventas.entity.enums.Genero;
import com.software.ventas.entity.enums.Talla;
import com.software.ventas.repository.ProductoRepository;

/**
 * Service class for managing {@link Producto} entities.
 * This class provides methods for CRUD operations and managing products in the system.
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #findAll()}: Retrieves all products.</li>
 *   <li>{@link #findById(Long)}: Retrieves a product by its ID.</li>
 *   <li>{@link #findByNombre(String)}: Retrieves a list of products matching the specified name.</li>
 *   <li>{@link #findByCategoria(String)}: Retrieves a list of products in the specified category.</li>
 *   <li>{@link #findByGenero(String)}: Retrieves a list of products matching the specified gender.</li>
 *   <li>{@link #findByTalla(String)}: Retrieves a list of products of the specified size.</li>
 *   <li>{@link #create(Producto, String)}: Creates a new product with the specified size.</li>
 *   <li>{@link #updateById(Long, Producto, String)}: Updates an existing product by its ID.</li>
 *   <li>{@link #deleteById(Long)}: Deletes a product by its ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be automatically injected by Spring.</li>
 *   <li>{@link Service}: Indicates that this class is a service component in Spring.</li>
 * </ul>
 * 
 * @see Producto
 * @see ProductoRepository
 * @see Categoria
 * @see Genero
 * @see Talla
 * 
 * Clase de servicio para gestionar entidades {@link Producto}.
 * Esta clase proporciona métodos para operaciones CRUD y gestión de productos en el sistema.
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>{@link #findAll()}: Recupera todos los productos.</li>
 *   <li>{@link #findById(Long)}: Recupera un producto por su ID.</li>
 *   <li>{@link #findByNombre(String)}: Recupera una lista de productos que coinciden con el nombre especificado.</li>
 *   <li>{@link #findByCategoria(String)}: Recupera una lista de productos en la categoría especificada.</li>
 *   <li>{@link #findByGenero(String)}: Recupera una lista de productos que coinciden con el género especificado.</li>
 *   <li>{@link #findByTalla(String)}: Recupera una lista de productos de la talla especificada.</li>
 *   <li>{@link #create(Producto, String)}: Crea un nuevo producto con la talla especificada.</li>
 *   <li>{@link #updateById(Long, Producto, String)}: Actualiza un producto existente por su ID.</li>
 *   <li>{@link #deleteById(Long)}: Elimina un producto por su ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link Service}: Indica que esta clase es un componente de servicio en Spring.</li>
 * </ul>
 * 
 * @see Producto
 * @see ProductoRepository
 * @see Categoria
 * @see Genero
 * @see Talla
 */


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> findByNombre(String nombre) {
        return productoRepository.findByName(nombre);
    }

    public List<Producto> findByCategoria(String categoria_str) {
        try {
            Categoria categoria = Categoria.valueOf(categoria_str);
            return productoRepository.findByCategoria(categoria);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoría inválida: " + categoria_str);
        }
    }

    public List<Producto> findByGenero(String genero_str) {
        try{
            Genero genero = Genero.valueOf(genero_str);
            return productoRepository.findByGenero(genero);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Género inválido: " + genero_str);
        }
    }

    public List<Producto> findByTalla(String talla_str) {
        try {
            Talla talla = Talla.valueOf("T" + talla_str);
            return productoRepository.findByTalla(talla);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Talla inválida: " + talla_str);
        }
    }

    public Producto create(Producto producto, String talla_str) {
        try {
            Talla talla = Talla.valueOf("T" + talla_str);
            producto.setTalla(talla);        
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Talla inválida: " + talla_str);
        }
        return productoRepository.save(producto);
    }

    public Producto updateById(Long id, Producto producto, String talla_str) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        Producto productoActualizado = productoOptional.get();
        productoActualizado.setNombre(producto.getNombre());
        productoActualizado.setDescripcion(producto.getDescripcion());
        productoActualizado.setPrecio(producto.getPrecio());
        productoActualizado.setCategoria(producto.getCategoria());
        productoActualizado.setGenero(producto.getGenero());
        productoActualizado.setUnidades(producto.getUnidades());
        try {
                Talla talla = Talla.valueOf("T" + talla_str);
                productoActualizado.setTalla(talla);        
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Talla inválida: " + talla_str);
            }            
            productoActualizado.setImagen(producto.getImagen());
            return productoRepository.save(productoActualizado);      
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }


    
}

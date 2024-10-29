package com.software.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.ventas.entity.Carrito;
import com.software.ventas.entity.Item;
import com.software.ventas.entity.Producto;
import com.software.ventas.repository.ItemRepository;

/**
 * Service class for managing {@link Item} entities.
 * This class provides methods for CRUD operations and managing items in a shopping cart.
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #findAll()}: Retrieves all items.</li>
 *   <li>{@link #findById(Long)}: Retrieves an item by its ID.</li>
 *   <li>{@link #findByCarritoId(Long)}: Retrieves a list of items associated with a specific shopping cart ID.</li>
 *   <li>{@link #findByProductoId(Long)}: Retrieves a list of items associated with a specific product ID.</li>
 *   <li>{@link #create(Integer, Long, Long)}: Creates a new item for the specified product and shopping cart.</li>
 *   <li>{@link #update(Long, Integer, Long, Long)}: Updates an existing item by ID, units, product, and cart ID.</li>
 *   <li>{@link #delete(Long)}: Deletes an item by its ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be automatically injected by Spring.</li>
 *   <li>{@link Service}: Indicates that this class is a service component in Spring.</li>
 * </ul>
 * 
 * @see Item
 * @see ItemRepository
 * @see Producto
 * @see Carrito
 * @see ProductoService
 * @see CarritoService
 * 
 * Clase de servicio para gestionar entidades {@link Item}.
 * Esta clase proporciona métodos para operaciones CRUD y gestión de artículos en un carrito de compras.
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>{@link #findAll()}: Recupera todos los artículos.</li>
 *   <li>{@link #findById(Long)}: Recupera un artículo por su ID.</li>
 *   <li>{@link #findByCarritoId(Long)}: Recupera una lista de artículos asociados con un ID de carrito específico.</li>
 *   <li>{@link #findByProductoId(Long)}: Recupera una lista de artículos asociados con un ID de producto específico.</li>
 *   <li>{@link #create(Integer, Long, Long)}: Crea un nuevo artículo para el producto y carrito especificados.</li>
 *   <li>{@link #update(Long, Integer, Long, Long)}: Actualiza un artículo existente por ID, unidades, producto e ID de carrito.</li>
 *   <li>{@link #delete(Long)}: Elimina un artículo por su ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link Service}: Indica que esta clase es un componente de servicio en Spring.</li>
 * </ul>
 * 
 * @see Item
 * @see ItemRepository
 * @see Producto
 * @see Carrito
 * @see ProductoService
 * @see CarritoService
 */


@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CarritoService carritoService;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findByCarritoId(Long carritoId) {
        return itemRepository.findByCarritoId(carritoId);
    }

    public List<Item> findByProductoId(Long productoId) {
        return itemRepository.findByProductoId(productoId);
    }

    public Item create(Integer unidades, Long producto_id, Long carrito_id) {
        Producto producto = productoService.findById(producto_id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        Carrito carrito = carritoService.findById(carrito_id)
                .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));

        Item item = new Item(unidades, producto, carrito);
        itemRepository.save(item);
        carrito.getItems().add(item);
        carrito.setTotal();
        carritoService.update(carrito.getId(), carrito.getCliente().getId());
        return itemRepository.save(item);
    }

    public Item update(Long id, Integer unidades, Long producto_id, Long carrito_id) {
        Item itemActualizado = itemRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Item no encontrado con el ID: " + id));
    
        Producto producto = productoService.findById(producto_id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        Carrito carrito = carritoService.findById(carrito_id)
                .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));
        itemActualizado.setProducto(producto);
        itemActualizado.setCarrito(carrito);
        itemActualizado.setUnidades(unidades);
        itemActualizado.setSubtotal();
        carrito.setTotal();
        carritoService.update(carrito.getId(), carrito.getCliente().getId());
        return itemRepository.save(itemActualizado);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);

    }

}

package com.software.ventas.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.ventas.entity.Carrito;
import com.software.ventas.entity.Cliente;
import com.software.ventas.entity.Item;
import com.software.ventas.entity.Orden;
import com.software.ventas.repository.CarritoRepository;

/**
 * Service class for managing {@link Carrito} entities.
 * This class provides methods for CRUD operations and managing shopping carts.
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #findAll()}: Retrieves all shopping carts.</li>
 *   <li>{@link #findById(Long)}: Retrieves a shopping cart by its ID.</li>
 *   <li>{@link #findByClienteId(Long)}: Retrieves a list of shopping carts associated with a specific client ID.</li>
 *   <li>{@link #create(Long)}: Creates a new shopping cart for a specific client.</li>
 *   <li>{@link #update(Long, Long)}: Updates an existing shopping cart with a new client ID.</li>
 *   <li>{@link #comprar(Long)}: Completes the purchase of the items in the cart and updates the status.</li>
 *   <li>{@link #delete(Long)}: Deletes a shopping cart by its ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be automatically injected by Spring.</li>
 *   <li>{@link Service}: Indicates that this class is a service component in Spring.</li>
 * </ul>
 * 
 * @see Carrito
 * @see CarritoRepository
 * @see ClienteService
 * @see OrdenService
 * 
 * Clase de servicio para gestionar entidades {@link Carrito}.
 * Esta clase proporciona métodos para operaciones CRUD y gestión de carritos de compra.
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>{@link #findAll()}: Recupera todos los carritos de compra.</li>
 *   <li>{@link #findById(Long)}: Recupera un carrito de compra por su ID.</li>
 *   <li>{@link #findByClienteId(Long)}: Recupera una lista de carritos de compra asociados con un ID de cliente específico.</li>
 *   <li>{@link #create(Long)}: Crea un nuevo carrito de compra para un cliente específico.</li>
 *   <li>{@link #update(Long, Long)}: Actualiza un carrito de compra existente con un nuevo ID de cliente.</li>
 *   <li>{@link #comprar(Long)}: Completa la compra de los artículos en el carrito y actualiza el estado.</li>
 *   <li>{@link #delete(Long)}: Elimina un carrito de compra por su ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link Service}: Indica que esta clase es un componente de servicio en Spring.</li>
 * </ul>
 * 
 * @see Carrito
 * @see CarritoRepository
 * @see ClienteService
 * @see OrdenService
 */


@Service
public class CarritoService {
    
    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private OrdenService ordenService;

    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> findById(Long id) {
        return carritoRepository.findById(id);
    }

    public List<Carrito> findByClienteId(Long ClienteId) {
        return carritoRepository.findByClienteId(ClienteId);
    }

    public Carrito create(Long cliente_id) {
        Cliente cliente = clienteService.findById(cliente_id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        Carrito carrito = new Carrito(cliente);
        carrito.setItems(new ArrayList<>()); // Inicializa la lista de items
        carrito.setTotal(); // Calcula el total
        return carritoRepository.save(carrito);
    }



    public Carrito update(Long id, Long cliente_id) {
        Optional<Carrito> carritoOptional = carritoRepository.findById(id);
        Carrito carritoActualizado = carritoOptional.get();
        Cliente cliente = clienteService.findById(cliente_id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        carritoActualizado.setCliente(cliente);
        return carritoRepository.save(carritoActualizado);
    }

public void comprar(Long id) {
    Carrito carrito = carritoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));

    if (carrito.getComprado()) {
        throw new IllegalArgumentException("El carrito ya ha sido comprado");
    }

    carrito.setComprado(true);
    
    
    Orden orden = ordenService.create(id);
    carrito.setOrden(orden);

    for (Item item : carrito.getItems()) {
        item.restarUnidades();
    }

    carritoRepository.save(carrito);
}


    public void delete(Long id) {
        carritoRepository.deleteById(id);
    }

}

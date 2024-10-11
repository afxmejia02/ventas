package com.software.ventas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Item;

/**
 * Repository interface for managing {@link Item} entities.
 * Extends {@link JpaRepository} to provide CRUD operations.
 * Contains custom query methods to find items by carrito ID and producto ID.
 * 
 * Methods:
 * - {@link #findByCarritoId(Long)}: Retrieves a list of items associated with a specific carrito ID.
 * - {@link #findByProductoId(Long)}: Retrieves a list of items associated with a specific producto ID.
 * 
 * Annotations:
 * - {@link Repository}: Indicates that this interface is a Spring Data repository.
 * - {@link Query}: Specifies custom JPQL queries for the methods.
 * 
 * @see JpaRepository
 * @see Item
 */

/**
 * Interfaz de repositorio para gestionar entidades {@link Item}.
 * Extiende {@link JpaRepository} para proporcionar operaciones CRUD.
 * Contiene métodos de consulta personalizados para encontrar ítems por ID de carrito y ID de producto.
 * 
 * Métodos:
 * - {@link #findByCarritoId(Long)}: Recupera una lista de ítems asociados con un ID de carrito específico.
 * - {@link #findByProductoId(Long)}: Recupera una lista de ítems asociados con un ID de producto específico.
 * 
 * Anotaciones:
 * - {@link Repository}: Indica que esta interfaz es un repositorio de Spring Data.
 * - {@link Query}: Especifica consultas JPQL personalizadas para los métodos.
 * 
 * @see JpaRepository
 * @see Item
 */


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.carrito.id = ?1")
    List<Item> findByCarritoId(Long carritoId);

    @Query("SELECT i FROM Item i WHERE i.producto.id = ?1")
    List<Item> findByProductoId(Long productoId);

}
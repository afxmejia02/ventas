package com.software.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Carrito;

/**
 * Repository interface for managing {@link Carrito} entities.
 * Extends {@link JpaRepository} to provide CRUD operations.
 * 
 * <p>This repository contains custom query methods for retrieving 
 * {@link Carrito} entities based on specific criteria.</p>
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #findByClienteId(Long)}: Retrieves a list of {@link Carrito} entities 
 *   associated with a specific client ID.</li>
 * </ul>
 * 
 * @see JpaRepository
 * @see Carrito
 */

/**
 * Interfaz de repositorio para gestionar entidades {@link Carrito}.
 * Extiende {@link JpaRepository} para proporcionar operaciones CRUD.
 * 
 * <p>Este repositorio contiene métodos de consulta personalizados para recuperar 
 * entidades {@link Carrito} basadas en criterios específicos.</p>
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>{@link #findByClienteId(Long)}: Recupera una lista de entidades {@link Carrito} 
 *   asociadas con un ID de cliente específico.</li>
 * </ul>
 * 
 * @see JpaRepository
 * @see Carrito
 */


@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

@Query("SELECT c FROM Carrito c WHERE c.cliente.id = ?1")
    List<Carrito> findByClienteId(Long clienteId);
    
}

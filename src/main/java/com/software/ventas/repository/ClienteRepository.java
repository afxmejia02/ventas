package com.software.ventas.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Cliente;

/**
 * Repository interface for managing {@link Cliente} entities.
 * Extends {@link JpaRepository} to provide CRUD operations.
 * 
 * <p>This repository contains a custom query method to find clients by their username.</p>
 * 
 * <p>Annotations:</p>
 * <ul>
 *  <li>{@link Repository}: Indicates that an annotated class is a repository.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 * <li>{@link #findByName(String)}: Retrieves a list of clients by username.</li>
 * </ul>
 * 
 * 
 * @see JpaRepository
 * @see Cliente
 */

/**
 * Interfaz de repositorio para gestionar entidades {@link Cliente}.
 * Extiende {@link JpaRepository} para proporcionar operaciones CRUD.
 * 
 * <p>Este repositorio contiene un método de consulta personalizado para encontrar clientes por su nombre de usuario.</p>
 * 
 * <p>Anotaciones:</p>
 * <ul>
 *  <li>{@link Repository}: Indica que una clase anotada es un repositorio.</li>
 * </ul>
 * 
 * <p>Métodos:</p>
 * <ul>
 * <li>{@link #findByName(String)}: Recupera una lista de clientes por nombre de usuario.</li>
 * </ul>
 * 
 * 
 * @see JpaRepository
 * @see Cliente
 */


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
        // Consulta personalizada para buscar clientes por nombre
    @Query("SELECT c FROM Cliente c WHERE c.nombre_usuario = ?1")
    List<Cliente> findByName(String nombre);
}



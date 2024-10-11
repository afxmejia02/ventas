package com.software.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.software.ventas.entity.Administrador;

/**
 * Repository interface for managing {@link Administrador} entities.
 * Extends {@link JpaRepository} to provide CRUD operations.
 * 
 * <p>This repository contains custom query methods for retrieving 
 * {@link Administrador} entities based on specific criteria.</p>
 * 
 * <p>Annotations:</p>
 * <ul>
 *  <li>{@link Repository}: Indicates that an annotated class is a repository.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 * <li>{@link #findByName(String)}: Retrieves a list of administrators by name.</li>
 * </ul>
 * 
 *  
 */

 /**
 * Interfaz de repositorio para gestionar entidades {@link Administrador}.
 * Extiende {@link JpaRepository} para proporcionar operaciones CRUD.
 * 
 * <p>Este repositorio contiene métodos de consulta personalizados para recuperar 
 * entidades {@link Administrador} basadas en criterios específicos.</p>
 * 
 * <p>Anotaciones:</p>
 * <ul>
 *  <li>{@link Repository}: Indica que una clase anotada es un repositorio.</li>
 * </ul>
 * 
 * <p>Métodos:</p>
 * <ul>
 * <li>{@link #findByName(String)}: Recupera una lista de administradores por nombre.</li>
 * </ul>
 * 
 */

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    @Query("SELECT a FROM Administrador a WHERE a.nombre_usuario = ?1")
    List<Administrador> findByName(String nombre);
    
}

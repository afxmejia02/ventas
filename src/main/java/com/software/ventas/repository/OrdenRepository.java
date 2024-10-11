package com.software.ventas.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Orden;
import java.util.List;

/**
 * Repository interface for managing {@link Orden} entities.
 * Extends {@link JpaRepository} to provide CRUD operations.
 * Contains custom query methods for retrieving orders based on client ID and date range.
 * 
 * Methods:
 * 
 * - {@link #findByClienteId(Long clienteId)}: Retrieves a list of orders associated with a specific client ID.
 * - {@link #findByFecha(LocalDate fecha_inicio, LocalDate fecha_fin)}: Retrieves a list of orders within a specified date range.
 * 
 * Annotations:
 * 
 * - {@link Repository}: Indicates that this interface is a Spring Data repository.
 * - {@link Query}: Specifies custom JPQL queries for the methods.
 * 
 * @see Orden
 * @see JpaRepository
 */

/**
 * Interfaz de repositorio para gestionar entidades {@link Orden}.
 * Extiende {@link JpaRepository} para proporcionar operaciones CRUD.
 * Contiene métodos de consulta personalizados para recuperar pedidos basados en el ID del cliente y el rango de fechas.
 * 
 * Métodos:
 * 
 * - {@link #findByClienteId(Long clienteId)}: Recupera una lista de pedidos asociados con un ID de cliente específico.
 * - {@link #findByFecha(LocalDate fecha_inicio, LocalDate fecha_fin)}: Recupera una lista de pedidos dentro de un rango de fechas específico.
 * 
 * Anotaciones:
 * 
 * - {@link Repository}: Indica que esta interfaz es un repositorio de Spring Data.
 * - {@link Query}: Especifica consultas JPQL personalizadas para los métodos.
 * 
 * @see Orden
 * @see JpaRepository
 */


@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    @Query("SELECT o FROM Orden o JOIN o.carrito c WHERE c.cliente.id = ?1")
    List<Orden> findByClienteId(Long clienteId);

    @Query("SELECT o FROM Orden o WHERE o.fecha BETWEEN ?1 AND ?2")
    List<Orden> findByFecha(LocalDate fecha_inicio, LocalDate fecha_fin);

}

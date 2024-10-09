package com.software.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.software.ventas.entity.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    // Consulta personalizada para buscar administradores por nombre
    @Query("SELECT a FROM Administrador a WHERE a.nombre_usuario = ?1")
    List<Administrador> findByName(String nombre);
    
}

package com.software.ventas.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
        // Consulta personalizada para buscar clientes por nombre
    @Query("SELECT c FROM Cliente c WHERE c.nombre = ?1")
    List<Cliente> findByName(String nombre);
}



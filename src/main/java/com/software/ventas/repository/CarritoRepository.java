package com.software.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Carrito;


@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
}

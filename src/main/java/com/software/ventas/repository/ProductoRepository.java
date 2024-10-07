package com.software.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

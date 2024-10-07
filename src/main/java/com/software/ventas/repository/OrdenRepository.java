package com.software.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Orden;


@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
}

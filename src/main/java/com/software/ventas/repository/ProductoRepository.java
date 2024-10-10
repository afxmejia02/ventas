package com.software.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Producto;
import com.software.ventas.entity.enums.Categoria;
import com.software.ventas.entity.enums.Genero;
import com.software.ventas.entity.enums.Talla;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE p.nombre = ?1")
    List<Producto> findByName(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.categoria = ?1")
    List<Producto> findByCategoria(Categoria categoria);

    @Query("SELECT p FROM Producto p WHERE p.genero = ?1")
    List<Producto> findByGenero(Genero genero);

    @Query("SELECT p FROM Producto p WHERE p.talla = ?1")
    List<Producto> findByTalla(Talla talla);
}

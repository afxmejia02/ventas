package com.software.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Producto;
import com.software.ventas.entity.enums.Categoria;
import com.software.ventas.entity.enums.Genero;
import com.software.ventas.entity.enums.Talla;

/**
 * Repository interface for managing {@link Producto} entities.
 * Extends {@link JpaRepository} to provide CRUD operations.
 * Contains custom query methods to find products by various attributes.
 * 
 * Methods:
 * - {@link #findByName(String)}: Finds products by their name.
 * - {@link #findByCategoria(Categoria)}: Finds products by their category.
 * - {@link #findByGenero(Genero)}: Finds products by their gender.
 * - {@link #findByTalla(Talla)}: Finds products by their size.
 * 
 * Annotations:
 * - {@link Repository}: Indicates that this interface is a Spring Data repository.
 * - {@link Query}: Specifies custom JPQL queries for the methods.
 * 
 * @see Producto
 * @see Categoria
 * @see Genero
 * @see Talla
 */

/**
 * Interfaz de repositorio para gestionar entidades {@link Producto}.
 * Extiende {@link JpaRepository} para proporcionar operaciones CRUD.
 * Contiene métodos de consulta personalizados para encontrar productos por varios atributos.
 * 
 * Métodos:
 * - {@link #findByName(String)}: Encuentra productos por su nombre.
 * - {@link #findByCategoria(Categoria)}: Encuentra productos por su categoría.
 * - {@link #findByGenero(Genero)}: Encuentra productos por su género.
 * - {@link #findByTalla(Talla)}: Encuentra productos por su talla.
 * 
 * Anotaciones:
 * - {@link Repository}: Indica que esta interfaz es un repositorio de Spring Data.
 * - {@link Query}: Especifica consultas JPQL personalizadas para los métodos.
 * 
 * @see Producto
 * @see Categoria
 * @see Genero
 * @see Talla
 */


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

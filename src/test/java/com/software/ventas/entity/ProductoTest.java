package com.software.ventas.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.software.ventas.entity.enums.Categoria;
import com.software.ventas.entity.enums.Genero;
import com.software.ventas.entity.enums.Talla;

public class ProductoTest {

    private Producto producto;

    @BeforeEach
    public void setUp() {
        producto = new Producto(
            1L, 
            "Zapatos Deportivos", 
            50.0, 
            "imagen.png", 
            "Zapatos para correr", 
            10, 
            Genero.M, 
            Categoria.DEPORTIVO, 
            "Nike", 
            Talla.T40
        );
    }

    @Test
    public void testGettersAndSetters() {
        // Verificar los getters
        assertEquals(1L, producto.getId());
        assertEquals("Zapatos Deportivos", producto.getNombre());
        assertEquals(50.0, producto.getPrecio());
        assertEquals("imagen.png", producto.getImagen());
        assertEquals("Zapatos para correr", producto.getDescripcion());
        assertEquals(10, producto.getUnidades());
        assertEquals(Genero.M, producto.getGenero());
        assertEquals(Categoria.DEPORTIVO, producto.getCategoria());
        assertEquals("Nike", producto.getMarca());
        assertEquals(Talla.T40, producto.getTalla());

        // Modificar y verificar los setters
        producto.setNombre("Nuevo Nombre");
        assertEquals("Nuevo Nombre", producto.getNombre());

        producto.setPrecio(75.0);
        assertEquals(75.0, producto.getPrecio());

        producto.setUnidades(20);
        assertEquals(20, producto.getUnidades());
    }

    @Test
    public void testUnidadesDisponibles() {
        // Verificar que hay unidades disponibles
        assertTrue(producto.unidadesDisponibles());
        // Modificar el número de unidades
        producto.setUnidades(0);
        assertFalse(producto.unidadesDisponibles());

    }

    @Test
    public void testToString() {
        String expectedString = "{ id='1', nombre='Zapatos Deportivos', Precio='50.0', imagen='imagen.png', descripcion='Zapatos para correr', unidades='10', genero='M', categoria='DEPORTIVO', marca='Nike', talla='T40'}";
        assertEquals(expectedString, producto.toString());
    }

    @Test
    public void testConstructorSinId() {
        // Verifica que se puede crear un producto sin un ID explícito
        Producto nuevoProducto = new Producto(null, "Camiseta", 20.0, "camiseta.png", "Camiseta casual", 5, Genero.F, Categoria.CASUAL, "Adidas", Talla.T38);

        assertNull(nuevoProducto.getId());
        assertEquals("Camiseta", nuevoProducto.getNombre());
        assertEquals(20.0, nuevoProducto.getPrecio());
        assertEquals(5, nuevoProducto.getUnidades());
        assertEquals(Genero.F, nuevoProducto.getGenero());
        assertEquals(Categoria.CASUAL, nuevoProducto.getCategoria());
        assertEquals("Adidas", nuevoProducto.getMarca());
        assertEquals(Talla.T38, nuevoProducto.getTalla());
    }
}


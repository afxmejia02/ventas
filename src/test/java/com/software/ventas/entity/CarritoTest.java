package com.software.ventas.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.software.ventas.entity.enums.Categoria;
import com.software.ventas.entity.enums.Genero;
import com.software.ventas.entity.enums.Talla;

public class CarritoTest {

    private Carrito carrito;
    private Producto producto;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        // Crear un producto con unidades disponibles
        producto = new Producto(1L, "Producto Test", 100.0, "imagen.jpg", "Descripcion de prueba", 10, Genero.U, Categoria.DEPORTIVO, "Marca Test", Talla.T42);
        cliente = new Cliente();
        cliente.setNombres("Juan");
        cliente.setApellidos("Perez");
        carrito = new Carrito(cliente);
        carrito.setId(1L);
        Item item1 = new Item(2, producto, carrito);
        Item item2 = new Item(3, producto, carrito);
        carrito.setItems(List.of(item1, item2));
        carrito.setTotal();
    }

    @Test
    void testCarritoNoEsNulo() {
        // Verificar que el carrito no sea nulo
        assertNotNull(carrito);
    }

    @Test
    void testCarritoNoCompradoInicialmente() {
        // Verificar que el carrito no está marcado como comprado inicialmente
        assertFalse(carrito.getComprado());
    }

    @Test
    void testCalculoTotalCarrito() {
        // Verificar el cálculo total del carrito
        double expectedTotal = (producto.getPrecio() * 2) + (producto.getPrecio() * 3);
        assertEquals(expectedTotal, carrito.getTotal());
    }

    @Test
    void testItemsEnCarrito() {
        // Verificar que los ítems se hayan añadido correctamente al carrito
        assertEquals(2, carrito.getItems().size());
        assertTrue(carrito.getItems().stream().allMatch(item -> item.getCarrito().equals(carrito)));
    }

    @Test
    void testAgregarItemAlCarrito() {
        // Crear un nuevo ítem y agregarlo al carrito
        Item nuevoItem = new Item(1, producto, carrito);
        carrito.setItems(List.of(nuevoItem));
        carrito.setTotal();

        // Verificar que el carrito ahora contenga 1 ítem
        assertEquals(1, carrito.getItems().size());
        assertEquals(nuevoItem, carrito.getItems().get(0));
    }

    @Test
    void testModificarCantidadItems() {
        // Modificar las unidades de un ítem existente
        carrito.getItems().get(0).setUnidades(5);
        carrito.setComprado(true);
        carrito.getItems().get(0).restarUnidades();
        carrito.getItems().get(1).restarUnidades();
        System.out.println(producto.getUnidades());
        carrito.setTotal();

        // Verificar el nuevo total del carrito
        double expectedTotal = (producto.getPrecio() * 5) + (producto.getPrecio() * 3);
        System.out.println(carrito.getTotal());
    
        assertEquals(expectedTotal, carrito.getTotal());
    }

    @Test
    void testCarritoConProductoSinUnidadesLanzaExcepcion() {
        // Crear un producto sin unidades disponibles
        Producto sinStock = new Producto(2L, "Producto Sin Stock", 50.0, "imagen.jpg", "Producto sin unidades", 0, Genero.U, Categoria.DEPORTIVO, "Marca Test", Talla.T42);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Item(1, sinStock, carrito);
        });
    
        assertEquals("No hay unidades disponibles del producto", exception.getMessage());
    }

    @Test
    void testExcepcionSiSeAgregaItemConMasUnidadesQueDisponibles() {
        // Verificar que se lanza una excepción si intentamos crear un ítem con más unidades de las disponibles
        Producto productoConPocasUnidades = new Producto(3L, "Producto Limitado", 120.0, "imagen.jpg", "Pocas unidades", 2, Genero.U, Categoria.DEPORTIVO, "Marca Limitada", Talla.T42);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Item(3, productoConPocasUnidades, carrito);
        });

        assertEquals("No hay unidades disponibles del producto", exception.getMessage());
    }

    @Test
    void testVaciarCarrito() {
        // Vaciar los ítems del carrito
        carrito.setItems(List.of());

        // Verificar que el carrito esté vacío
        assertTrue(carrito.getItems().isEmpty());

        // Verificar que el total sea 0.0
        carrito.setTotal();
        assertEquals(0.0, carrito.getTotal());
    }

    @Test
    void testMarcarCarritoComoComprado() {
        // Marcar el carrito como comprado
        carrito.setComprado(true);

        // Verificar que el carrito está marcado como comprado
        assertTrue(carrito.getComprado());

        // Verificar que se creó una orden
        carrito.setOrden();
        System.out.println(carrito.getOrden());
        assertNotNull(carrito.getOrden());

    }
}


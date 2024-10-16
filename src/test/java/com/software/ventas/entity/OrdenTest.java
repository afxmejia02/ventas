package com.software.ventas.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

import com.software.ventas.entity.enums.Categoria;
import com.software.ventas.entity.enums.Genero;
import com.software.ventas.entity.enums.Talla;

public class OrdenTest {

    private Carrito carrito;
    private Producto producto;
    private Cliente cliente;
    private Orden orden;

    @BeforeEach
    void setUp() {
        // Crear un cliente
        cliente = new Cliente();
        cliente.setNombres("Juan");
        cliente.setApellidos("Pérez");

        // Crear un producto con unidades disponibles
        producto = new Producto(1L, "Producto Test", 100.0, "imagen.jpg", "Descripcion de prueba", 10, Genero.U, Categoria.DEPORTIVO, "Marca Test", Talla.T42);

        // Crear un carrito y marcarlo como comprado
        carrito = new Carrito(cliente);
        carrito.setId(1L);
        carrito.setComprado(true);
        Item item1 = new Item(2, producto, carrito);
        carrito.setItems(List.of(item1));
        carrito.setTotal();
    }

    @Test
    void testCrearOrdenConCarritoComprado() {
        // Crear la orden con el carrito comprado
        orden = new Orden(carrito);

        // Verificar que la orden se crea con los valores correctos
        assertNotNull(orden);
        assertEquals(carrito, orden.getCarrito());
        assertEquals("Juan Pérez", orden.getCliente());
        assertEquals(carrito.getTotal(), orden.getTotal());
        assertEquals(LocalDate.now(), orden.getFecha());
    }

    @Test
    void testCrearOrdenConCarritoNoCompradoLanzaExcepcion() {
        // Marcar el carrito como no comprado
        carrito.setComprado(false);

        // Verificar que se lanza una excepción cuando se intenta crear la orden
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Orden(carrito);
        });

        assertEquals("El carrito debe estar marcado como comprado para crear una orden.", exception.getMessage());
    }

    @Test
    void testModificarIdOrden() {
        // Crear la orden
        orden = new Orden(carrito);

        // Modificar el ID de la orden
        orden.setId(100L);
        assertEquals(100L, orden.getId());
    }

    @Test
    void testToStringOrden() {
        // Crear la orden
        orden = new Orden(carrito);

        // Verificar que el método toString() devuelve el formato esperado
        String expectedString = "Orden{id=null, fecha=" + LocalDate.now() + ", cliente=Juan Pérez, total=" + carrito.getTotal() + "}";
        assertEquals(expectedString, orden.toString());
    }

    @Test
    void testTotalCorrectoEnOrden() {
        // Crear la orden
        orden = new Orden(carrito);

        // Verificar que el total de la orden corresponde al total del carrito
        assertEquals(carrito.getTotal(), orden.getTotal());
    }

    @Test
    void testFechaCorrectaEnOrden() {
        // Crear la orden
        orden = new Orden(carrito);

        // Verificar que la fecha es la fecha actual
        assertEquals(LocalDate.now(), orden.getFecha());
    }
}


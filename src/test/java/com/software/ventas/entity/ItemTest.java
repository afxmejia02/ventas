package com.software.ventas.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.software.ventas.entity.enums.Categoria;
import com.software.ventas.entity.enums.Genero;
import com.software.ventas.entity.enums.Talla;


public class ItemTest {

    private Producto producto;
    private Carrito carrito;
    private Item item;

    @BeforeEach
    void setUp() {
        // Crear un producto con unidades disponibles
        producto = new Producto(1L, "Producto Test", 100.0, "imagen.jpg", "Descripcion de prueba", 10, Genero.U, Categoria.DEPORTIVO, "Marca Test", Talla.T42);

        // Crear un carrito
        carrito = new Carrito();
        carrito.setComprado(false);


        // Crear el item con 2 unidades
        item = new Item(2, producto, carrito);
    }

    @Test
    void testCrearItemConProductoDisponible() {
        assertNotNull(item);
        assertEquals(2, item.getUnidades());
        assertEquals(200.0, item.getSubtotal());
    }

    @Test
    void testProductoSinUnidadesDisponibles() {
        // Crear un producto sin unidades disponibles
        Producto productoSinStock = new Producto(2L, "Producto Sin Stock", 50.0, "imagen2.jpg", "Producto sin stock", 0, Genero.M, Categoria.RUNNING, "MarcaX", Talla.T40);
        
        // Intentar crear un Item con un producto sin unidades
        Item itemSinStock = new Item(3, productoSinStock, carrito);
        
        // No se debería permitir la creación de un item con unidades
        assertNull(itemSinStock.getProducto());
    }

    @Test
    void testActualizarUnidadesEnProductoTrasCompra() {
        // Marcar el carrito como comprado
        carrito.setComprado(true);
        
        // Recalcular subtotal y actualizar unidades
        item.setSubtotal();
        
        // El producto debe haber disminuido las unidades
        assertEquals(8, producto.getUnidades());
    }

    @Test
    void testNoActualizarUnidadesSinCompra() {
        // Si el carrito no está comprado, las unidades no deben cambiar
        item.setSubtotal();
        
        assertEquals(10, producto.getUnidades()); // Las unidades originales se mantienen
    }

    @Test
    void testItemConUnidadesIncorrectas() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Item(12, producto, carrito);
        });
        System.out.println(producto.getUnidades());
        assertEquals("No hay unidades disponibles del producto", exception.getMessage());
    }
}

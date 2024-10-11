package com.software.ventas.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.software.ventas.entity.enums.TipoDocumento;

import java.time.LocalDate;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        // Crear una instancia de Cliente para usar en las pruebas
        cliente = new Cliente("usuarioTest", "passwordTest", "Andres", "Mejia", "123456789", LocalDate.of(1990, 10, 10));
        cliente.setTipo_documento(TipoDocumento.CE);
        System.out.println(cliente.getHashcontraseña());
    }

    @Test
    public void testGetId() {
        // Asegurarse de que el ID es null antes de ser asignado
        assertNull(cliente.getId());

        // Asignar un ID y verificar
        cliente.setId(1L);
        assertEquals(1L, cliente.getId());
    }

    @Test
    public void testGetNombreUsuario() {
        assertEquals("usuarioTest", cliente.getNombre());
    }

    @Test
    public void testSetNombreUsuario() {
        cliente.setNombre("nuevoUsuario");
        assertEquals("nuevoUsuario", cliente.getNombre());
    }

    @Test
    public void testGetHashContraseña() {
        assertEquals("passwordTest", cliente.getHashcontraseña());
        System.out.println(cliente.getHashcontraseña());
    }

    @Test
    public void testSetHashContraseña() {
        cliente.setHashcontraseña("nuevaPassword");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
        System.out.println(cliente.getHashcontraseña());
        System.out.println(new BCryptPasswordEncoder().encode("nuevaPassword"));
        assertTrue(encoder.matches("nuevaPassword", cliente.getHashcontraseña()));
    }

    @Test
    public void testVerificarContraseña() {
        cliente.setHashcontraseña("passwordTest");
        assertTrue(cliente.verificarContraseña("passwordTest"));
        System.out.println(cliente.getHashcontraseña());
        assertFalse(cliente.verificarContraseña("incorrectPassword"));
    }

    @Test
    public void testGetNombres() {
        assertEquals("Andres", cliente.getNombres());
    }

    @Test
    public void testSetNombres() {
        cliente.setNombres("Felipe");
        assertEquals("Felipe", cliente.getNombres());
    }

    @Test
    public void testGetApellidos() {
        assertEquals("Mejia", cliente.getApellidos());
    }

    @Test
    public void testSetApellidos() {
        cliente.setApellidos("Gomez");
        assertEquals("Gomez", cliente.getApellidos());
    }

    @Test
    public void testGetTipoDocumento() {
        assertEquals(TipoDocumento.CE, cliente.getTipo_documento());
    }

    @Test
    public void testSetTipoDocumento() {
        cliente.setTipo_documento(TipoDocumento.PP);
        assertEquals(TipoDocumento.PP, cliente.getTipo_documento());
    }

    @Test
    public void testGetNumeroDocumento() {
        assertEquals("123456789", cliente.getNumero_documento());
    }

    @Test
    public void testSetNumeroDocumento() {
        cliente.setNumero_documento("987654321");
        assertEquals("987654321", cliente.getNumero_documento());
    }

    @Test
    public void testGetFechaNacimiento() {
        assertEquals(LocalDate.of(1990, 10, 10), cliente.getFecha_nacimiento());
    }

    @Test
    public void testSetFechaNacimiento() {
        LocalDate nuevaFecha = LocalDate.of(1985, 5, 5);
        cliente.setFecha_nacimiento(nuevaFecha);
        assertEquals(nuevaFecha, cliente.getFecha_nacimiento());
    }

    @Test
    public void testToString() {
        String expected = "{ id='null', nombres='Andres', apellidos='Mejia', tipo_documento='CE', numero_documento='123456789', fecha_nacimiento='1990-10-10'}";
        assertEquals(expected, cliente.toString());
        System.out.println(expected);
        
    }
}

    


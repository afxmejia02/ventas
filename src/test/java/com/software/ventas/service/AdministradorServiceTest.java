package com.software.ventas.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.software.ventas.entity.Administrador;
import com.software.ventas.repository.AdministradorRepository;

public class AdministradorServiceTest {

    @InjectMocks
    private AdministradorService administradorService;

    @Mock
    private AdministradorRepository administradorRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Dado
        Administrador admin1 = new Administrador();
        Administrador admin2 = new Administrador();
        when(administradorRepository.findAll()).thenReturn(Arrays.asList(admin1, admin2));

        // Cuando
        List<Administrador> administradores = administradorService.findAll();

        // Entonces
        assertEquals(2, administradores.size());
        verify(administradorRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        // Dado
        Long id = 1L;
        Administrador admin = new Administrador();
        when(administradorRepository.findById(id)).thenReturn(Optional.of(admin));

        // Cuando
        Optional<Administrador> result = administradorService.findById(id);

        // Entonces
        assertTrue(result.isPresent());
        verify(administradorRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByNombre() {
        // Dado
        String nombre = "Juan";
        Administrador admin = new Administrador();
        when(administradorRepository.findByName(nombre)).thenReturn(Arrays.asList(admin));

        // Cuando
        List<Administrador> result = administradorService.findByNombre(nombre);

        // Entonces
        assertEquals(1, result.size());
        verify(administradorRepository, times(1)).findByName(nombre);
    }

    @Test
    public void testIngresarUsuario_ValidCredentials() {
        // Dado
        String nombre = "admin";
        String contrasena = "12345";
        Administrador admin = mock(Administrador.class);
        when(administradorRepository.findByName(nombre)).thenReturn(Arrays.asList(admin));
        when(admin.verificarContraseña(contrasena)).thenReturn(true);

        // Cuando
        boolean result = administradorService.ingresarUsuario(nombre, contrasena);

        // Entonces
        assertTrue(result);
        verify(administradorRepository, times(1)).findByName(nombre);
        verify(admin, times(1)).verificarContraseña(contrasena);
    }

    @Test
    public void testIngresarUsuario_InvalidCredentials() {
        // Dado
        String nombre = "admin";
        String contrasena = "wrongpassword";
        Administrador admin = mock(Administrador.class);
        when(administradorRepository.findByName(nombre)).thenReturn(Arrays.asList(admin));
        when(admin.verificarContraseña(contrasena)).thenReturn(false);

        // Cuando
        boolean result = administradorService.ingresarUsuario(nombre, contrasena);

        // Entonces
        assertFalse(result);
        verify(administradorRepository, times(1)).findByName(nombre);
        verify(admin, times(1)).verificarContraseña(contrasena);
    }

@Test
public void testCreate() {
    // Dado
    Administrador admin = new Administrador();
    String contrasena = "newpassword";
    
    Administrador adminSpy = spy(admin);

    when(administradorRepository.save(adminSpy)).thenReturn(adminSpy);

    // Cuando
    Administrador result = administradorService.create(adminSpy, contrasena);

    // Entonces
    assertNotNull(result);
    verify(adminSpy, times(1)).setHashcontraseña(anyString());
    verify(administradorRepository, times(1)).save(adminSpy);
    assertNotEquals(contrasena, adminSpy.getHashcontraseña());
}


    @Test
    public void testUpdateById_AdministradorExists() {
        // Dado
        Long id = 1L;
        Administrador adminExistente = new Administrador();
        Administrador adminActualizado = new Administrador();
        adminActualizado.setNombre("Nuevo Nombre");
        adminActualizado.setHashcontraseña("newpassword");

        when(administradorRepository.findById(id)).thenReturn(Optional.of(adminExistente));
        when(administradorRepository.save(adminExistente)).thenReturn(adminExistente);

        // Cuando
        Administrador result = administradorService.updateById(id, adminActualizado);

        // Entonces
        assertNotNull(result);
        verify(administradorRepository, times(1)).findById(id);
        verify(administradorRepository, times(1)).save(adminExistente);
    }

    @Test
    public void testUpdateById_AdministradorNotFound() {
        // Dado
        Long id = 1L;
        Administrador adminActualizado = new Administrador();
        when(administradorRepository.findById(id)).thenReturn(Optional.empty());

        // Cuando
        Administrador result = administradorService.updateById(id, adminActualizado);

        // Entonces
        assertNull(result);
        verify(administradorRepository, times(1)).findById(id);
        verify(administradorRepository, never()).save(any());
    }

    @Test
    public void testUpdateContrasena_ValidPassword() {
        // Dado
        Long id = 1L;
        String oldPassword = "oldpassword";
        String newPassword = "newpassword";
        Administrador admin = mock(Administrador.class);

        when(administradorRepository.findById(id)).thenReturn(Optional.of(admin));
        when(admin.verificarContraseña(oldPassword)).thenReturn(true);
        when(administradorRepository.save(admin)).thenReturn(admin);

        // Cuando
        Administrador result = administradorService.updateContrasena(id, oldPassword, newPassword);

        // Entonces
        assertNotNull(result);
        verify(admin, times(1)).setHashcontraseña(newPassword);
        verify(administradorRepository, times(1)).save(admin);
    }

    @Test
    public void testUpdateContrasena_InvalidPassword() {
        // Dado
        Long id = 1L;
        String oldPassword = "wrongpassword";
        String newPassword = "newpassword";
        Administrador admin = mock(Administrador.class);

        when(administradorRepository.findById(id)).thenReturn(Optional.of(admin));
        when(admin.verificarContraseña(oldPassword)).thenReturn(false);

        // Cuando
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            administradorService.updateContrasena(id, oldPassword, newPassword);
        });

        // Entonces
        assertEquals("La contraseña actual es incorrecta", exception.getMessage());
        verify(administradorRepository, times(1)).findById(id);
        verify(admin, never()).setHashcontraseña(anyString());
        verify(administradorRepository, never()).save(any());
    }

    @Test
    public void testDeleteById() {
        // Dado
        Long id = 1L;

        // Cuando
        administradorService.deleteById(id);

        // Entonces
        verify(administradorRepository, times(1)).deleteById(id);
    }
}


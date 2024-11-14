package com.software.ventas.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.software.ventas.entity.Administrador;
import com.software.ventas.service.AdministradorService;


import java.util.Arrays;
import java.util.Optional;

@WebMvcTest(AdministradorController.class)
public class AdministradorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdministradorService administradorService;

    @Autowired
    private ObjectMapper objectMapper;  // Para convertir objetos a JSON

    private Administrador admin;

    @BeforeEach
    void setup() {
        admin = new Administrador();
        admin.setId(1L);
        admin.setNombre("Admin1");
        admin.setHashcontraseña("hashedPassword");
    }

    @Test
    public void testFindAll() throws Exception {
        when(administradorService.findAll()).thenReturn(Arrays.asList(admin));

        mockMvc.perform(get("/admin"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].nombre").value("Admin1"));
        
        verify(administradorService, times(1)).findAll();
    }

    @Test
    public void testFindById() throws Exception {
        when(administradorService.findById(1L)).thenReturn(Optional.of(admin));

        mockMvc.perform(get("/admin/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Admin1"));
        
        verify(administradorService, times(1)).findById(1L);
    }

    @Test
    public void testFindByNombre() throws Exception {
        when(administradorService.findByNombre("Admin1")).thenReturn(Arrays.asList(admin));

        mockMvc.perform(get("/admin/nombre/Admin1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].nombre").value("Admin1"));
        
        verify(administradorService, times(1)).findByNombre("Admin1");
    }

    @Test
    public void testIngresarUsuario() throws Exception {
        when(administradorService.ingresarUsuario("Admin1", "password")).thenReturn(true);

        mockMvc.perform(get("/admin/ingresar")
            .param("nombre", "Admin1")
            .param("contrasena", "password"))
            .andExpect(status().isOk())
            .andExpect(content().string("true"));
        
        verify(administradorService, times(1)).ingresarUsuario("Admin1", "password");
    }

    @Test
    public void testCreate() throws Exception {
        when(administradorService.create(any(Administrador.class), eq("password"))).thenReturn(admin);

        mockMvc.perform(post("/admin/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(admin))
            .param("contrasena", "password"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Admin1"));
        
        verify(administradorService, times(1)).create(any(Administrador.class), eq("password"));
    }

    @Test
    public void testUpdateById() throws Exception {
        when(administradorService.updateById(eq(1L), any(Administrador.class))).thenReturn(admin);

        mockMvc.perform(put("/admin/update/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(admin)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Admin1"));
        
        verify(administradorService, times(1)).updateById(eq(1L), any(Administrador.class));
    }

    @Test
    public void testUpdatePassword() throws Exception {
        when(administradorService.updateContrasena(1L, "oldPassword", "newPassword")).thenReturn(admin);

        mockMvc.perform(put("/admin/update-password/1")
            .param("contrasena", "oldPassword")
            .param("nuevoContrasena", "newPassword"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Admin1"));
        
        verify(administradorService, times(1)).updateContrasena(1L, "oldPassword", "newPassword");
    }

    @Test
    public void testDeleteById() throws Exception {
        doNothing().when(administradorService).deleteById(1L);

        mockMvc.perform(delete("/admin/delete/1"))
            .andExpect(status().isOk());
        
        verify(administradorService, times(1)).deleteById(1L);
    }
}


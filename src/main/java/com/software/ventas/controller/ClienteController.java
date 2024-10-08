package com.software.ventas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.ventas.entity.Cliente;
import com.software.ventas.service.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente>  findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Cliente> findByNombre(@PathVariable String nombre) {
        return clienteService.findByNombre(nombre);
    }

    @GetMapping("/ingresar")
    public boolean ingresarUsuario(@RequestParam String nombre, @RequestParam String contrasena) {
        return clienteService.ingresarUsuario(nombre, contrasena);
    }

    @PostMapping("/create")
    public Cliente create(@RequestBody Cliente cliente, @RequestParam String tipodocumento_String, @RequestParam String contrasena) {
        return clienteService.create(cliente, tipodocumento_String, contrasena);
    }

    @PutMapping("/update/{id}")
    public Cliente updateById(@PathVariable Long id, @RequestBody Cliente cliente, @RequestParam String tipodocumento_String) {
        return clienteService.updateById(id, cliente, tipodocumento_String);
    }

    @PutMapping("/update-password/{id}")
    public Cliente updatePassword(@PathVariable Long id, @RequestParam String contrasena, @RequestParam String nuevoContrasena) {
        return clienteService.updateContraseña(id, contrasena, nuevoContrasena);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
    }
    
    

    
    
}

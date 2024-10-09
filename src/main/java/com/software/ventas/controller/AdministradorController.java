package com.software.ventas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.software.ventas.entity.Administrador;
import com.software.ventas.service.AdministradorService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/admin")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping()
    public List<Administrador> findAll() {
        return administradorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Administrador> findById(@PathVariable Long id) {
        return administradorService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Administrador> findByNombre(@PathVariable String nombre) {
        return administradorService.findByNombre(nombre);
    }

    @GetMapping("/ingresar")
    public boolean ingresarUsuario(@RequestParam String nombre, @RequestParam String contrasena) {
        return administradorService.ingresarUsuario(nombre, contrasena);
    }

    @PostMapping("/create")
    public Administrador create(@RequestBody Administrador administrador, @RequestParam String contrasena) {
        return administradorService.create(administrador, contrasena);
    }

    @PutMapping("/update/{id}")
    public Administrador updateById(@PathVariable Long id, @RequestBody Administrador administrador) {
        return administradorService.updateById(id, administrador);
    }

    @PutMapping("/update-password/{id}")
    public Administrador updatePassword(@PathVariable Long id, @RequestParam String contrasena, @RequestParam String nuevoContrasena) {
        return administradorService.updateContrasena(id, contrasena, nuevoContrasena);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        administradorService.deleteById(id);
    }
   
    
}

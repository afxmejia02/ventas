package com.software.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.ventas.entity.Administrador;
import com.software.ventas.repository.AdministradorRepository;

@Service
public class AdministradorService {
    
    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    public Optional<Administrador> findById(Long id) {
        return administradorRepository.findById(id);
    }

    public List<Administrador> findByNombre(String nombre) {
        return administradorRepository.findByName(nombre);
    }

    public boolean ingresarUsuario(String nombre, String contrasena) {
        // Buscar el administrador por nombre
        List<Administrador> administradores = administradorRepository.findByName(nombre);

        // Verificar si la lista está vacía
        if (administradores.isEmpty()) {
            // Si no se encuentra el administrador, las credenciales son inválidas
            return false;
        }

        Administrador administrador = administradores.get(0);

        // Verificar si el administrador existe y la contraseña coincide
        if (administrador != null && administrador.verificarContraseña(contrasena)) {
            // Credenciales válidas
            return true;
        }
        // Credenciales inválidas
        return false;
    }
    
    public Administrador create(Administrador administrador, String contrasena) {
        administrador.setHashcontraseña(contrasena);
        return administradorRepository.save(administrador);
    }

    public Administrador updateById(Long id, Administrador administrador) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id);
        if (administradorOptional.isPresent()) {
            Administrador administradorActualizado = administradorOptional.get();
            administradorActualizado.setNombre(administrador.getNombre());
            administradorActualizado.setHashcontraseña(administrador.getHashcontraseña());
            return administradorRepository.save(administradorActualizado);
        }
        return null;
    }
    
    public Administrador updateContrasena(Long id, String password, String newPassword) {
        Administrador administradorToUpdate = administradorRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Administrador no encontrado"));
        if (administradorToUpdate.verificarContraseña(password)) {
            administradorToUpdate.setHashcontraseña(newPassword);
            return administradorRepository.save(administradorToUpdate);
        }
        else{
            throw new IllegalArgumentException("La contraseña actual es incorrecta");      
        }
    }

    public void deleteById(Long id) {
        administradorRepository.deleteById(id);
    }
}

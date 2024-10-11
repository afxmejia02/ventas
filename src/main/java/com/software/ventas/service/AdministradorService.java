package com.software.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.ventas.entity.Administrador;
import com.software.ventas.repository.AdministradorRepository;

/**
 * Service class for managing {@link Administrador} entities.
 * This class provides methods for CRUD operations and authentication for administrators.
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #findAll()}: Retrieves all administrators.</li>
 *   <li>{@link #findById(Long)}: Retrieves an administrator by their ID.</li>
 *   <li>{@link #findByNombre(String)}: Retrieves a list of administrators by their name.</li>
 *   <li>{@link #ingresarUsuario(String, String)}: Validates administrator credentials.</li>
 *   <li>{@link #create(Administrador, String)}: Creates a new administrator.</li>
 *   <li>{@link #updateById(Long, Administrador)}: Updates an existing administrator by their ID.</li>
 *   <li>{@link #updateContrasena(Long, String, String)}: Updates the administrator's password.</li>
 *   <li>{@link #deleteById(Long)}: Deletes an administrator by their ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be automatically injected by Spring.</li>
 *   <li>{@link Service}: Indicates that this class is a service component in Spring.</li>
 * </ul>
 * 
 * @see Administrador
 * @see AdministradorRepository
 */

/**
 * Clase de servicio para gestionar entidades {@link Administrador}.
 * Esta clase proporciona métodos para operaciones CRUD y autenticación de administradores.
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>{@link #findAll()}: Recupera todos los administradores.</li>
 *   <li>{@link #findById(Long)}: Recupera un administrador por su ID.</li>
 *   <li>{@link #findByNombre(String)}: Recupera una lista de administradores por su nombre.</li>
 *   <li>{@link #ingresarUsuario(String, String)}: Valida las credenciales del administrador.</li>
 *   <li>{@link #create(Administrador, String)}: Crea un nuevo administrador.</li>
 *   <li>{@link #updateById(Long, Administrador)}: Actualiza un administrador existente por su ID.</li>
 *   <li>{@link #updateContrasena(Long, String, String)}: Actualiza la contraseña del administrador.</li>
 *   <li>{@link #deleteById(Long)}: Elimina un administrador por su ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link Service}: Indica que esta clase es un componente de servicio en Spring.</li>
 * </ul>
 * 
 * @see Administrador
 * @see AdministradorRepository
 */


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

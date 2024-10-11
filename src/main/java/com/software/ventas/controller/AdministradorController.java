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

/**
 * Controller class for managing {@link Administrador} entities.
 * This class handles HTTP requests related to administrators and their operations.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /admin - Retrieves a list of all administrators.</li>
 *   <li>{@link #findById(Long)}: GET /admin/{id} - Retrieves an administrator by its ID.</li>
 *   <li>{@link #findByNombre(String)}: GET /admin/nombre/{nombre} - Retrieves a list of administrators by name.</li>
 *   <li>{@link #ingresarUsuario(String, String)}: GET /admin/ingresar - Validates administrator login credentials.</li>
 *   <li>{@link #create(Administrador, String)}: POST /admin/create - Creates a new administrator.</li>
 *   <li>{@link #updateById(Long, Administrador)}: PUT /admin/update/{id} - Updates an existing administrator by ID.</li>
 *   <li>{@link #updatePassword(Long, String, String)}: PUT /admin/update-password/{id} - Updates the password of an administrator.</li>
 *   <li>{@link #deleteById(Long)}: DELETE /admin/delete/{id} - Deletes an administrator by ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be automatically injected by Spring.</li>
 *   <li>{@link RestController}: Indicates that this class is a REST controller.</li>
 *   <li>{@link RequestMapping}: Specifies the base URI for all endpoints in this controller.</li>
 * </ul>
 * 
 * @see Administrador
 * @see AdministradorService
 * 
 * Clase de controlador para gestionar entidades {@link Administrador}.
 * Esta clase maneja solicitudes HTTP relacionadas con los administradores y sus operaciones.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /admin - Recupera una lista de todos los administradores.</li>
 *   <li>{@link #findById(Long)}: GET /admin/{id} - Recupera un administrador por su ID.</li>
 *   <li>{@link #findByNombre(String)}: GET /admin/nombre/{nombre} - Recupera una lista de administradores por nombre.</li>
 *   <li>{@link #ingresarUsuario(String, String)}: GET /admin/ingresar - Valida las credenciales de inicio de sesión del administrador.</li>
 *   <li>{@link #create(Administrador, String)}: POST /admin/create - Crea un nuevo administrador.</li>
 *   <li>{@link #updateById(Long, Administrador)}: PUT /admin/update/{id} - Actualiza un administrador existente por ID.</li>
 *   <li>{@link #updatePassword(Long, String, String)}: PUT /admin/update-password/{id} - Actualiza la contraseña de un administrador.</li>
 *   <li>{@link #deleteById(Long)}: DELETE /admin/delete/{id} - Elimina un administrador por ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link RestController}: Indica que esta clase es un controlador REST.</li>
 *   <li>{@link RequestMapping}: Especifica la URI base para todos los puntos finales en este controlador.</li>
 * </ul>
 * 
 * @see Administrador
 * @see AdministradorService
 */


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

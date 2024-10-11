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

/**
 * Controller class to manage {@link Cliente} entities.
 * This class handles HTTP requests related to clients and their operations.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /clientes - Retrieves a list of all clients.</li>
 *   <li>{@link #findById(Long)}: GET /clientes/{id} - Retrieves a client by its ID.</li>
 *   <li>{@link #findByNombre(String)}: GET /clientes/nombre/{nombre} - Retrieves a list of clients by name.</li>
 *   <li>{@link #ingresarUsuario(String, String)}: GET /clientes/ingresar - Authenticates a user by name and password.</li>
 *   <li>{@link #create(Cliente, String, String)}: POST /clientes/create - Creates a new client.</li>
 *   <li>{@link #updateById(Long, Cliente, String)}: PUT /clientes/update/{id} - Updates an existing client by ID.</li>
 *   <li>{@link #updatePassword(Long, String, String)}: PUT /clientes/update-password/{id} - Updates the password of a client.</li>
 *   <li>{@link #deleteById(Long)}: DELETE /clientes/delete/{id} - Deletes a client by ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be injected automatically by Spring.</li>
 *   <li>{@link RestController}: Indicates that this class is a REST controller.</li>
 *   <li>{@link RequestMapping}: Specifies the base URI for all endpoints in this controller.</li>
 * </ul>
 * 
 * @see Cliente
 * @see ClienteService
 */

/**
 * Clase de controlador para gestionar entidades {@link Cliente}.
 * Esta clase maneja las solicitudes HTTP relacionadas con los clientes y sus operaciones.
 * 
 * <p>Endpoints:</p>
 * <ul>
 *   <li>{@link #findAll()}: GET /clientes - Recupera una lista de todos los clientes.</li>
 *   <li>{@link #findById(Long)}: GET /clientes/{id} - Recupera un cliente por su ID.</li>
 *   <li>{@link #findByNombre(String)}: GET /clientes/nombre/{nombre} - Recupera una lista de clientes por nombre.</li>
 *   <li>{@link #ingresarUsuario(String, String)}: GET /clientes/ingresar - Autentica a un usuario por nombre y contraseña.</li>
 *   <li>{@link #create(Cliente, String, String)}: POST /clientes/create - Crea un nuevo cliente.</li>
 *   <li>{@link #updateById(Long, Cliente, String)}: PUT /clientes/update/{id} - Actualiza un cliente existente por ID.</li>
 *   <li>{@link #updatePassword(Long, String, String)}: PUT /clientes/update-password/{id} - Actualiza la contraseña de un cliente.</li>
 *   <li>{@link #deleteById(Long)}: DELETE /clientes/delete/{id} - Elimina un cliente por ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link RestController}: Indica que esta clase es un controlador REST.</li>
 *   <li>{@link RequestMapping}: Especifica la URI base para todos los endpoints en este controlador.</li>
 * </ul>
 * 
 * @see Cliente
 * @see ClienteService
 */


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

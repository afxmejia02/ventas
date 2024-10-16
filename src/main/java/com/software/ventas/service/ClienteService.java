package com.software.ventas.service;

import java.util.List;
import java.util.Optional;

import com.software.ventas.entity.Cliente;
import com.software.ventas.entity.enums.TipoDocumento;
import com.software.ventas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing {@link Cliente} entities.
 * This class provides methods for CRUD operations and managing clients.
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #findAll()}: Retrieves all clients.</li>
 *   <li>{@link #findById(Long)}: Retrieves a client by its ID.</li>
 *   <li>{@link #findByNombre(String)}: Retrieves a list of clients associated with a specific name.</li>
 *   <li>{@link #ingresarUsuario(String, String)}: Validates user credentials for login.</li>
 *   <li>{@link #create(Cliente, String, String)}: Creates a new client with the specified document type and password.</li>
 *   <li>{@link #updateById(Long, Cliente, String)}: Updates an existing client by ID and document type.</li>
 *   <li>{@link #updateContraseña(Long, String, String)}: Updates the password of a client.</li>
 *   <li>{@link #deleteById(Long)}: Deletes a client by its ID.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link Autowired}: Indicates that a dependency should be automatically injected by Spring.</li>
 *   <li>{@link Service}: Indicates that this class is a service component in Spring.</li>
 * </ul>
 * 
 * @see Cliente
 * @see ClienteRepository
 * @see TipoDocumento
 * 
 * Clase de servicio para gestionar entidades {@link Cliente}.
 * Esta clase proporciona métodos para operaciones CRUD y gestión de clientes.
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>{@link #findAll()}: Recupera todos los clientes.</li>
 *   <li>{@link #findById(Long)}: Recupera un cliente por su ID.</li>
 *   <li>{@link #findByNombre(String)}: Recupera una lista de clientes asociados con un nombre específico.</li>
 *   <li>{@link #ingresarUsuario(String, String)}: Valida las credenciales del usuario para iniciar sesión.</li>
 *   <li>{@link #create(Cliente, String, String)}: Crea un nuevo cliente con el tipo de documento y contraseña especificados.</li>
 *   <li>{@link #updateById(Long, Cliente, String)}: Actualiza un cliente existente por ID y tipo de documento.</li>
 *   <li>{@link #updateContraseña(Long, String, String)}: Actualiza la contraseña de un cliente.</li>
 *   <li>{@link #deleteById(Long)}: Elimina un cliente por su ID.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>{@link Autowired}: Indica que una dependencia debe ser inyectada automáticamente por Spring.</li>
 *   <li>{@link Service}: Indica que esta clase es un componente de servicio en Spring.</li>
 * </ul>
 * 
 * @see Cliente
 * @see ClienteRepository
 * @see TipoDocumento
 */


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> findByNombre(String nombre) {       
        return clienteRepository.findByName(nombre);
    }
    
    public boolean ingresarUsuario(String nombre, String contrasena) {
        List<Cliente> clientes = clienteRepository.findByName(nombre);

        
    if (clientes.isEmpty()) {
        return false;
    }

    Cliente cliente = clientes.get(0);

        if (cliente != null && cliente.verificarContraseña(contrasena)) {
            return true;
        }
        return false;
    }

    public Cliente getClienteLogin(String nombre, String contrasena) {
        if (ingresarUsuario(nombre, contrasena)) {
            List<Cliente> clientes = clienteRepository.findByName(nombre);
            return clientes.get(0);
        }
        else{
            throw new IllegalArgumentException("Usuario o contraseña incorrectos"); //
        }
    }

    public Cliente create(Cliente cliente, String tipodocumento_String, String contrasena) {
        TipoDocumento tipo_documento;
        try {
            tipo_documento = TipoDocumento.valueOf(tipodocumento_String); 
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de documento inválido: " + tipodocumento_String);
        }
        cliente.setTipo_documento(tipo_documento);
        cliente.setHashcontraseña(contrasena);
        return clienteRepository.save(cliente);
    }

    public Cliente updateById(Long id, Cliente cliente, String tipodocumento_String) {
        Cliente clienteToUpdate = clienteRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        clienteToUpdate.setNombre_usuario(cliente.getNombre_usuario());
        clienteToUpdate.setNombres(cliente.getNombres());
        clienteToUpdate.setApellidos(cliente.getApellidos());
        
        TipoDocumento tipo_documento;
        try {
            tipo_documento = TipoDocumento.valueOf(tipodocumento_String); 
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de documento inválido: " + tipodocumento_String);
        }

        clienteToUpdate.setTipo_documento(tipo_documento);
        clienteToUpdate.setNumero_documento(cliente.getNumero_documento());
        clienteToUpdate.setFecha_nacimiento(cliente.getFecha_nacimiento());
        return clienteRepository.save(clienteToUpdate);
    }

    public Cliente updateContraseña(Long id, String password, String newPassword) { 
        Cliente clienteToUpdate = clienteRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        if (clienteToUpdate.verificarContraseña(password)) {
            clienteToUpdate.setHashcontraseña(newPassword);
            return clienteRepository.save(clienteToUpdate);
        }
        else{
            throw new IllegalArgumentException("La contraseña actual es incorrecta");      
        }
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
    
}

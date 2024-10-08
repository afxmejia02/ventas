package com.software.ventas.service;

import java.util.List;
import java.util.Optional;

import com.software.ventas.entity.Cliente;
import com.software.ventas.entity.enums.TipoDocumento;
import com.software.ventas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // Buscar el cliente por nombre
        List<Cliente> clientes = clienteRepository.findByName(nombre);

            // Verificar si la lista está vacía
    if (clientes.isEmpty()) {
        // Si no se encuentra el cliente, las credenciales son inválidas
        return false;
    }

    Cliente cliente = clientes.get(0);

        // Verificar si el cliente existe y la contraseña coincide
        if (cliente != null && cliente.verificarContraseña(contrasena)) {
            // Credenciales válidas
            return true;
        }
        // Credenciales inválidas
        return false;
    }

    public Cliente create(Cliente cliente, String tipodocumento_String, String contrasena) {
        TipoDocumento tipo_documento;
        try {
            tipo_documento = TipoDocumento.valueOf(tipodocumento_String); // Intenta convertir el String a enum
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
        clienteToUpdate.setNombre(cliente.getNombres());
        clienteToUpdate.setApellidos(cliente.getApellidos());
        
        TipoDocumento tipo_documento;
        try {
            tipo_documento = TipoDocumento.valueOf(tipodocumento_String); // Intenta convertir el String a enum
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de documento inválido: " + tipodocumento_String);
        }

        clienteToUpdate.setTipo_documento(tipo_documento);
        clienteToUpdate.setNumero_documento(cliente.getNumero_documento());
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

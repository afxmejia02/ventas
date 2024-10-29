package com.software.ventas.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Represents a user entity with basic authentication features.
 * This class is annotated with @MappedSuperclass, indicating that it is a base class for JPA entities.
 * It uses Lombok annotations for generating boilerplate code like getters, setters, and constructors.
 * 
 * <p>Attributes:</p>
 * <ul>
 *   <li>nombre_usuario: The username of the user.</li>
 *   <li>hashcontraseña: The hashed password of the user.</li>
 * </ul>
 * 
 * <p>Constructors:</p>
 * <ul>
 *   <li>Usuario(): Default no-argument constructor.</li>
 *   <li>Usuario(Long id, String nombre, String contraseña): Constructor with parameters for id, username, and password.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>getNombre(): Returns the username.</li>
 *   <li>setNombre(String nombre): Sets the username.</li>
 *   <li>getHashcontraseña(): Returns the hashed password.</li>
 *   <li>setHashcontraseña(String contraseña): Sets and hashes the password using BCrypt.</li>
 *   <li>verificarContraseña(String contraseña): Verifies if the provided password matches the hashed password.</li>
 * </ul>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>jakarta.persistence.MappedSuperclass: JPA annotation for marking a class as a base class.</li>
 *   <li>lombok.Getter, lombok.Setter, lombok.NoArgsConstructor, lombok.AllArgsConstructor: Lombok annotations for generating boilerplate code.</li>
 *   <li>org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder: Utility for hashing and verifying passwords.</li>
 * </ul>
 */

/**
 * Representa una entidad de usuario con características básicas de autenticación.
 * Esta clase está anotada con @MappedSuperclass, lo que indica que es una clase base para las entidades JPA.
 * Utiliza anotaciones de Lombok para generar código repetitivo como getters, setters y constructores.
 * 
 * <p>Atributos:</p>
 * <ul>
 *   <li>nombre_usuario: El nombre de usuario del usuario.</li>
 *   <li>hashcontraseña: La contraseña hasheada del usuario.</li>
 * </ul>
 * 
 * <p>Constructores:</p>
 * <ul>
 *   <li>Usuario(): Constructor por defecto sin argumentos.</li>
 *   <li>Usuario(Long id, String nombre, String contraseña): Constructor con parámetros para id, nombre de usuario y contraseña.</li>
 * </ul>
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>getNombre(): Devuelve el nombre de usuario.</li>
 *   <li>setNombre(String nombre): Establece el nombre de usuario.</li>
 *   <li>getHashcontraseña(): Devuelve la contraseña hasheada.</li>
 *   <li>setHashcontraseña(String contraseña): Establece y hashea la contraseña utilizando BCrypt.</li>
 *   <li>verificarContraseña(String contraseña): Verifica si la contraseña proporcionada coincide con la contraseña hasheada.</li>
 * </ul>
 * 
 * <p>Dependencias:</p>
 * <ul>
 *   <li>jakarta.persistence.MappedSuperclass: Anotación JPA para marcar una clase como clase base.</li>
 *   <li>lombok.Getter, lombok.Setter, lombok.NoArgsConstructor, lombok.AllArgsConstructor: Anotaciones de Lombok para generar código repetitivo.</li>
 *   <li>org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder: Utilidad para hashear y verificar contraseñas.</li>
 * </ul>
 */



@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    
    private String nombre_usuario;
    private String hashcontraseña;
    
    public Usuario(Long id, String nombre, String contraseña) {
        this.nombre_usuario = nombre;
        setHashcontraseña(contraseña);
    }
      
    public String getNombre() {
        return nombre_usuario;
    }

    public void setNombre(String nombre) {
        this.nombre_usuario = nombre;
    }

    public String getHashcontraseña() {
        return hashcontraseña;
    }

    public void setHashcontraseña(String contraseña) {
        this.hashcontraseña = new BCryptPasswordEncoder().encode(contraseña);
    }

    public boolean verificarContraseña(String contraseña) {
        return new BCryptPasswordEncoder().matches(contraseña, this.hashcontraseña);
    }


}

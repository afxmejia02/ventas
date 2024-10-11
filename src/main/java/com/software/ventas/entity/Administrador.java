package com.software.ventas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an administrator entity in the system.
 * This class extends the {@link Usuario} class and includes additional attributes and methods specific to an administrator.
 * 
 * <p>Annotations:</p>
 * <ul>
 *   <li>{@link Entity} - Specifies that this class is an entity and is mapped to a database table.</li>
 *   <li>{@link Table} - Specifies the name of the database table to be used for mapping.</li>
 *   <li>{@link Data} - A Lombok annotation to generate getters, setters, toString, equals, and hashCode methods.</li>
 *   <li>{@link EqualsAndHashCode} - A Lombok annotation to generate equals and hashCode methods, calling the superclass methods.</li>
 *   <li>{@link Getter} - A Lombok annotation to generate getter methods for all fields.</li>
 *   <li>{@link Setter} - A Lombok annotation to generate setter methods for all fields.</li>
 * </ul>
 * 
 * <p>Attributes:</p>
 * <ul>
 *   <li>{@code id} - The unique identifier for the administrator. It is auto-generated.</li>
 * </ul>
 * 
 * <p>Constructors:</p>
 * <ul>
 *   <li>{@link #Administrador(String, String)} - Constructs a new administrator with the specified name and password.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #toString()} - Returns a string representation of the administrator.</li>
 *   <li>{@link #getId()} - Returns the unique identifier of the administrator.</li>
 *   <li>{@link #setId(Long)} - Sets the unique identifier of the administrator.</li>
 *   <li>{@link #getNombre()} - Returns the name of the administrator.</li>
 *   <li>{@link #setNombre(String)} - Sets the name of the administrator.</li>
 *   <li>{@link #getHashcontraseña()} - Returns the hashed password of the administrator.</li>
 *   <li>{@link #setHashcontraseña(String)} - Sets the hashed password of the administrator.</li>
 *   <li>{@link #verificarContraseña(String)} - Verifies the given password against the stored hashed password.</li>
 * </ul>
 */

/**
 * Representa una entidad de administrador en el sistema.
 * Esta clase extiende la clase {@link Usuario} e incluye atributos y métodos adicionales específicos para un administrador.
 * 
 * <p>Anotaciones:</p>
 * <ul>
 *   <li>{@link Entity} - Especifica que esta clase es una entidad y está mapeada a una tabla de base de datos.</li>
 *   <li>{@link Table} - Especifica el nombre de la tabla de base de datos que se usará para el mapeo.</li>
 *   <li>{@link Data} - Una anotación de Lombok que genera métodos getters, setters, toString, equals y hashCode.</li>
 *   <li>{@link EqualsAndHashCode} - Una anotación de Lombok que genera los métodos equals y hashCode, llamando a los métodos de la superclase.</li>
 *   <li>{@link Getter} - Una anotación de Lombok que genera métodos getter para todos los campos.</li>
 *   <li>{@link Setter} - Una anotación de Lombok que genera métodos setter para todos los campos.</li>
 * </ul>
 * 
 * <p>Atributos:</p>
 * <ul>
 *   <li>{@code id} - El identificador único para el administrador. Es auto-generado.</li>
 * </ul>
 * 
 * <p>Constructores:</p>
 * <ul>
 *   <li>{@link #Administrador(String, String)} - Construye un nuevo administrador con el nombre y la contraseña especificados.</li>
 * </ul>
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>{@link #toString()} - Devuelve una representación en cadena del administrador.</li>
 *   <li>{@link #getId()} - Devuelve el identificador único del administrador.</li>
 *   <li>{@link #setId(Long)} - Establece el identificador único del administrador.</li>
 *   <li>{@link #getNombre()} - Devuelve el nombre del administrador.</li>
 *   <li>{@link #setNombre(String)} - Establece el nombre del administrador.</li>
 *   <li>{@link #getHashcontraseña()} - Devuelve la contraseña cifrada del administrador.</li>
 *   <li>{@link #setHashcontraseña(String)} - Establece la contraseña cifrada del administrador.</li>
 *   <li>{@link #verificarContraseña(String)} - Verifica la contraseña proporcionada contra la contraseña cifrada almacenada.</li>
 * </ul>
 */

@Getter
@Setter
@Entity
@Table(name = "administrador")
@Data
@EqualsAndHashCode(callSuper = true)
public class Administrador extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Administrador(String nombre, String contraseña) {
        super(nombre, contraseña);
    }

    public String toString() {
        return "Administrador{" +
                "id=" + id +
                ", nombre='" + getNombre() + '\'' +
                ", contraseña='" + getHashcontraseña() + '\'' +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getHashcontraseña() {
        return super.getHashcontraseña();
    }

    @Override
    public void setHashcontraseña(String contraseña) {
        super.setHashcontraseña(contraseña);
    }

    @Override
    public boolean verificarContraseña(String contraseña) {
        return super.verificarContraseña(contraseña);
    }

    
}

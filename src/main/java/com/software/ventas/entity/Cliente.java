package com.software.ventas.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

import com.software.ventas.entity.enums.TipoDocumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a client entity in the system.
 * This class extends the Usuario class and includes additional attributes specific to a client.
 * It is annotated with JPA annotations to map it to a database table named "cliente".
 * 
 * Annotations:
 * - @Entity: Specifies that the class is an entity and is mapped to a database table.
 * - @Table: Specifies the name of the table to be used for mapping.
 * - @Id: Specifies the primary key of an entity.
 * - @GeneratedValue: Provides for the specification of generation strategies for the values of primary keys.
 * 
 * Attributes:
 * - id: The unique identifier for the client.
 * - nombres: The first names of the client.
 * - apellidos: The last names of the client.
 * - tipo_documento: The type of document (e.g., passport, ID card) of the client.
 * - numero_documento: The document number of the client.
 * - fecha_nacimiento: The birth date of the client.
 * 
 * Constructors:
 * - Cliente(): Default constructor.
 * - Cliente(String nombre_usuario, String contraseña, String nombres, String apellidos, String numero_documento, LocalDate fecha_nacimiento): 
 *   Parameterized constructor to initialize a client with the given attributes.
 * 
 * Methods:
 * - getId(): Returns the unique identifier of the client.
 * - setId(Long id): Sets the unique identifier of the client.
 * - getNombre(): Returns the username of the client.
 * - setNombre(String nombre_usuario): Sets the username of the client.
 * - getHashcontraseña(): Returns the hashed password of the client.
 * - setHashcontraseña(String contraseña): Sets the hashed password of the client.
 * - verificarContraseña(String contraseña): Verifies the given password against the stored hashed password.
 * - getNombres(): Returns the first names of the client.
 * - setNombres(String nombres): Sets the first names of the client.
 * - getApellidos(): Returns the last names of the client.
 * - setApellidos(String apellidos): Sets the last names of the client.
 * - getTipo_documento(): Returns the type of document of the client.
 * - setTipo_documento(TipoDocumento tipo_documento): Sets the type of document of the client.
 * - getNumero_documento(): Returns the document number of the client.
 * - setNumero_documento(String numero_documento): Sets the document number of the client.
 * - getFecha_nacimiento(): Returns the birth date of the client.
 * - setFecha_nacimiento(LocalDate fecha_nacimiento): Sets the birth date of the client.
 * - toString(): Returns a string representation of the client object.
 */

/**
 * Representa una entidad cliente en el sistema.
 * Esta clase extiende la clase Usuario e incluye atributos adicionales específicos para un cliente.
 * Está anotada con anotaciones JPA para mapearla a una tabla de base de datos llamada "cliente".
 * 
 * Anotaciones:
 * - @Entity: Especifica que la clase es una entidad y se mapea a una tabla de base de datos.
 * - @Table: Especifica el nombre de la tabla que se utilizará para el mapeo.
 * - @Id: Especifica la clave primaria de una entidad.
 * - @GeneratedValue: Proporciona la especificación de estrategias de generación para los valores de las claves primarias.
 * 
 * Atributos:
 * - id: El identificador único para el cliente.
 * - nombres: Los nombres del cliente.
 * - apellidos: Los apellidos del cliente.
 * - tipo_documento: El tipo de documento (por ejemplo, pasaporte, cédula) del cliente.
 * - numero_documento: El número de documento del cliente.
 * - fecha_nacimiento: La fecha de nacimiento del cliente.
 * 
 * Constructores:
 * - Cliente(): Constructor por defecto.
 * - Cliente(String nombre_usuario, String contraseña, String nombres, String apellidos, String numero_documento, LocalDate fecha_nacimiento): 
 *   Constructor parametrizado para inicializar un cliente con los atributos proporcionados.
 * 
 * Métodos:
 * - getId(): Devuelve el identificador único del cliente.
 * - setId(Long id): Establece el identificador único del cliente.
 * - getNombre(): Devuelve el nombre de usuario del cliente.
 * - setNombre(String nombre_usuario): Establece el nombre de usuario del cliente.
 * - getHashcontraseña(): Devuelve la contraseña encriptada del cliente.
 * - setHashcontraseña(String contraseña): Establece la contraseña encriptada del cliente.
 * - verificarContraseña(String contraseña): Verifica la contraseña proporcionada contra la contraseña encriptada almacenada.
 * - getNombres(): Devuelve los nombres del cliente.
 * - setNombres(String nombres): Establece los nombres del cliente.
 * - getApellidos(): Devuelve los apellidos del cliente.
 * - setApellidos(String apellidos): Establece los apellidos del cliente.
 * - getTipo_documento(): Devuelve el tipo de documento del cliente.
 * - setTipo_documento(TipoDocumento tipo_documento): Establece el tipo de documento del cliente.
 * - getNumero_documento(): Devuelve el número de documento del cliente.
 * - setNumero_documento(String numero_documento): Establece el número de documento del cliente.
 * - getFecha_nacimiento(): Devuelve la fecha de nacimiento del cliente.
 * - setFecha_nacimiento(LocalDate fecha_nacimiento): Establece la fecha de nacimiento del cliente.
 * - toString(): Devuelve una representación en cadena del objeto cliente.
 */



@Getter
@Setter
@Entity
@Table(name = "cliente")
@Data
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombres;
    
    @Column
    private String apellidos;

    @Enumerated(EnumType.STRING) 
    @Column
    private TipoDocumento tipo_documento;

    @Column
    private String numero_documento;

    @Column
    private LocalDate fecha_nacimiento;

    public Cliente() {}

    public Cliente(String nombre_usuario, String contraseña, String nombres, String apellidos, String numero_documento, LocalDate fecha_nacimiento) {
        super(nombre_usuario, contraseña);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero_documento = numero_documento;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombres='" + getNombres() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", tipo_documento='" + getTipo_documento() + "'" +
            ", numero_documento='" + getNumero_documento() + "'" +
            ", fecha_nacimiento='" + getFecha_nacimiento() + "'" +
            "}";
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
    
    @Override
    public void setNombre(String nombre_usuario) {
        super.setNombre(nombre_usuario);
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

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public TipoDocumento getTipo_documento() {
        return this.tipo_documento;
    }

    public void setTipo_documento(TipoDocumento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return this.numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public LocalDate getFecha_nacimiento() {
        return this.fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    


    
}

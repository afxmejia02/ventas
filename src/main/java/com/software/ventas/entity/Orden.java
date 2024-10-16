package com.software.ventas.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an order entity in the ventas system.
 * This entity is mapped to the "orden" table in the database.
 * 
 * An order is created from a shopping cart (Carrito) that has been marked as purchased.
 * 
 * The Orden class includes the following fields:
 * - id: The unique identifier for the order.
 * - carrito: The shopping cart associated with the order.
 * - fecha: The date the order was created.
 * - cliente: The name of the client who made the order.
 * - total: The total amount of the order.
 * 
 * The class provides getter and setter methods for each field, 
 * and a custom constructor to initialize an order from a purchased shopping cart.
 * 
 * The class also overrides the toString() method to provide a string representation of the order.
 * 
 * An IllegalArgumentException is thrown if an attempt is made to create an order from a shopping cart 
 * that has not been marked as purchased.
 * 
 * Annotations:
 * - @Entity: Specifies that the class is an entity and is mapped to a database table.
 * - @Table: Specifies the name of the database table to be used for mapping.
 * - @Id: Specifies the primary key of the entity.
 * - @GeneratedValue: Provides for the specification of generation strategies for the values of primary keys.
 * - @JsonIgnore: Indicates that the carrito field should be ignored during JSON serialization.
 * - @OneToOne: Specifies a single-valued association to another entity that has one-to-one multiplicity.
 * - @JoinColumn: Specifies the foreign key column.
 * - @Column: Specifies the mapped column for a persistent property or field.
 * - @Getter, @Setter, @Data: Lombok annotations to generate boilerplate code like getters, setters, and other utility methods.
 * 
 * Constructor:
 * - Orden(): Default constructor.
 * - Orden(Carrito carrito): Initializes an order from a purchased shopping cart.
 * 
 * Methods:
 * - getId(): Returns the order ID.
 * - setId(Long id): Sets the order ID.
 * - getFecha(): Returns the order date.
 * - setFecha(): Sets the order date to the current date.
 * - getCliente(): Returns the client name.
 * - setCliente(): Sets the client name based on the associated shopping cart's client.
 * - getCarrito(): Returns the associated shopping cart.
 * - setCarrito(Carrito carrito): Sets the associated shopping cart.
 * - getTotal(): Returns the total amount of the order.
 * - setTotal(): Sets the total amount of the order based on the associated shopping cart's total.
 * - toString(): Returns a string representation of the order.
 */

/**
 * Representa una entidad de orden en el sistema de ventas.
 * Esta entidad está mapeada a la tabla "orden" en la base de datos.
 * 
 * Una orden se crea a partir de un carrito de compras (Carrito) que ha sido marcado como comprado.
 * 
 * La clase Orden incluye los siguientes campos:
 * - id: El identificador único de la orden.
 * - carrito: El carrito de compras asociado con la orden.
 * - fecha: La fecha en que se creó la orden.
 * - cliente: El nombre del cliente que realizó la orden.
 * - total: El monto total de la orden.
 * 
 * La clase proporciona métodos getter y setter para cada campo, 
 * y un constructor personalizado para inicializar una orden a partir de un carrito de compras comprado.
 * 
 * La clase también sobrescribe el método toString() para proporcionar una representación en cadena de la orden.
 * 
 * Se lanza una IllegalArgumentException si se intenta crear una orden a partir de un carrito de compras 
 * que no ha sido marcado como comprado.
 * 
 * Anotaciones:
 * - @Entity: Especifica que la clase es una entidad y está mapeada a una tabla de base de datos.
 * - @Table: Especifica el nombre de la tabla de la base de datos que se utilizará para el mapeo.
 * - @Id: Especifica la clave primaria de la entidad.
 * - @GeneratedValue: Proporciona la especificación de estrategias de generación para los valores de las claves primarias.
 * - @JsonIgnore: Indica que el campo carrito debe ser ignorado durante la serialización JSON.
 * - @OneToOne: Especifica una asociación de valor único con otra entidad que tiene multiplicidad uno a uno.
 * - @JoinColumn: Especifica la columna de clave foránea.
 * - @Column: Especifica la columna mapeada para una propiedad o campo persistente.
 * - @Getter, @Setter, @Data: Anotaciones de Lombok para generar código repetitivo como getters, setters y otros métodos utilitarios.
 * 
 * Constructor:
 * - Orden(): Constructor por defecto.
 * - Orden(Carrito carrito): Inicializa una orden a partir de un carrito de compras comprado.
 * 
 * Métodos:
 * - getId(): Devuelve el ID de la orden.
 * - setId(Long id): Establece el ID de la orden.
 * - getFecha(): Devuelve la fecha de la orden.
 * - setFecha(): Establece la fecha de la orden a la fecha actual.
 * - getCliente(): Devuelve el nombre del cliente.
 * - setCliente(): Establece el nombre del cliente basado en el cliente del carrito de compras asociado.
 * - getCarrito(): Devuelve el carrito de compras asociado.
 * - setCarrito(Carrito carrito): Establece el carrito de compras asociado.
 * - getTotal(): Devuelve el monto total de la orden.
 * - setTotal(): Establece el monto total de la orden basado en el total del carrito de compras asociado.
 * - toString(): Devuelve una representación en cadena de la orden.
 */


@Getter
@Setter
@Entity
@Table(name = "orden")
@Data
public class Orden {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "carrito_id", referencedColumnName = "id")
    private Carrito carrito;

    @Column
    private LocalDate fecha;
    
    @Column
    private String cliente;

    @Column
    private Double total;
    
    public Orden(){
    }

    public Orden(Carrito carrito){
        if (!carrito.getComprado()) {
            throw new IllegalArgumentException("El carrito debe estar marcado como comprado para crear una orden.");
        }
        this.carrito = carrito;
        setFecha();
        setCliente();
        setTotal();
    }

    public String toString(){
        return "Orden{"+
        "id="+id+
        ", fecha="+fecha+
        ", cliente="+cliente+
        ", total="+total+
        "}";
    }

    
    public Long getId(){
        return this.id;

    }

    public Long setId(Long id){
        return this.id = id;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }

    public LocalDate setFecha(){
        return this.fecha = LocalDate.now();
    }

    public String getCliente(){
        return this.cliente;
    }

    public String setCliente(){
        return this.cliente = this.getCarrito().getCliente().getNombres()+" "+this.getCarrito().getCliente().getApellidos();
    }

    public Carrito getCarrito(){
        return this.carrito;
    }

    public Carrito setCarrito(Carrito carrito){
        return this.carrito = carrito;
    }

    public Double getTotal(){
        return this.total;
    }

    public Double setTotal(){
        return this.total = this.carrito.getTotal();
    }

}

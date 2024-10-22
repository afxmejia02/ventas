package com.software.ventas.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a shopping cart (Carrito) entity in the system.
 * This entity is mapped to the "carrito" table in the database.
 * It contains information about the items in the cart, the total cost,
 * whether the cart has been purchased, the associated client, and the order.
 * 
 * <p>Annotations:</p>
 * <ul>
 *   <li>{@link Entity}: Specifies that the class is an entity and is mapped to a database table.</li>
 *   <li>{@link Table}: Specifies the name of the database table to be used for mapping.</li>
 *   <li>{@link Id}: Specifies the primary key of an entity.</li>
 *   <li>{@link GeneratedValue}: Provides for the specification of generation strategies for the values of primary keys.</li>
 *   <li>{@link JsonIgnore}: Indicates that the annotated field should be ignored by Jackson during serialization and deserialization.</li>
 *   <li>{@link OneToMany}: Defines a one-to-many relationship.</li>
 *   <li>{@link ManyToOne}: Defines a many-to-one relationship.</li>
 *   <li>{@link OneToOne}: Defines a one-to-one relationship.</li>
 *   <li>{@link JoinColumn}: Specifies a column for joining an entity association or element collection.</li>
 *   <li>{@link Column}: Specifies the mapped column for a persistent property or field.</li>
 *   <li>{@link Getter}, {@link Setter}, {@link Data}: Lombok annotations to generate boilerplate code like getters, setters, and other utility methods.</li>
 * </ul>
 * 
 * <p>Fields:</p>
 * <ul>
 *   <li>{@code id}: The unique identifier for the cart.</li>
 *   <li>{@code items}: The list of items in the cart.</li>
 *   <li>{@code total}: The total cost of the items in the cart.</li>
 *   <li>{@code comprado}: Indicates whether the cart has been purchased.</li>
 *   <li>{@code cliente}: The client associated with the cart.</li>
 *   <li>{@code orden}: The order associated with the cart.</li>
 * </ul>
 * 
 * <p>Constructors:</p>
 * <ul>
 *   <li>{@link #Carrito()}: Default constructor.</li>
 *   <li>{@link #Carrito(Cliente cliente)}: Constructor to initialize the cart with a client.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #toString()}: Returns a string representation of the cart.</li>
 *   <li>{@link #getId()}: Returns the id of the cart.</li>
 *   <li>{@link #setId(Long id)}: Sets the id of the cart.</li>
 *   <li>{@link #getItems()}: Returns the list of items in the cart.</li>
 *   <li>{@link #setItems(List<Item> items)}: Sets the list of items in the cart, filtering by the cart's id.</li>
 *   <li>{@link #getTotal()}: Returns the total cost of the items in the cart.</li>
 *   <li>{@link #setTotal()}: Calculates and sets the total cost of the items in the cart.</li>
 *   <li>{@link #getComprado()}: Returns whether the cart has been purchased.</li>
 *   <li>{@link #setComprado(Boolean comprado)}: Sets whether the cart has been purchased.</li>
 *   <li>{@link #getCliente()}: Returns the client associated with the cart.</li>
 *   <li>{@link #setCliente(Cliente cliente)}: Sets the client associated with the cart.</li>
 *   <li>{@link #getOrden()}: Returns the order associated with the cart.</li>
 *   <li>{@link #setOrden()}: Creates and sets the order if the cart has been purchased, otherwise throws an exception.</li>
 * </ul>
 */

 /**
 * Representa una entidad de carrito de compras (Carrito) en el sistema.
 * Esta entidad está mapeada a la tabla "carrito" en la base de datos.
 * Contiene información sobre los artículos en el carrito, el costo total,
 * si el carrito ha sido comprado, el cliente asociado y el pedido.
 * 
 * <p>Anotaciones:</p>
 * <ul>
 *   <li>{@link Entity}: Especifica que la clase es una entidad y está mapeada a una tabla de base de datos.</li>
 *   <li>{@link Table}: Especifica el nombre de la tabla de la base de datos a usar para el mapeo.</li>
 *   <li>{@link Id}: Especifica la clave primaria de una entidad.</li>
 *   <li>{@link GeneratedValue}: Proporciona la especificación de las estrategias de generación para los valores de claves primarias.</li>
 *   <li>{@link JsonIgnore}: Indica que el campo anotado debe ser ignorado por Jackson durante la serialización y deserialización.</li>
 *   <li>{@link OneToMany}: Define una relación uno a muchos.</li>
 *   <li>{@link ManyToOne}: Define una relación de muchos a uno.</li>
 *   <li>{@link OneToOne}: Define una relación uno a uno.</li>
 *   <li>{@link JoinColumn}: Especifica una columna para unir una asociación de entidad o colección de elementos.</li>
 *   <li>{@link Column}: Especifica la columna mapeada para una propiedad o campo persistente.</li>
 *   <li>{@link Getter}, {@link Setter}, {@link Data}: Anotaciones de Lombok para generar código repetitivo como getters, setters y otros métodos utilitarios.</li>
 * </ul>
 * 
 * <p>Campos:</p>
 * <ul>
 *   <li>{@code id}: El identificador único del carrito.</li>
 *   <li>{@code items}: La lista de artículos en el carrito.</li>
 *   <li>{@code total}: El costo total de los artículos en el carrito.</li>
 *   <li>{@code comprado}: Indica si el carrito ha sido comprado.</li>
 *   <li>{@code cliente}: El cliente asociado con el carrito.</li>
 *   <li>{@code orden}: El pedido asociado con el carrito.</li>
 * </ul>
 * 
 * <p>Constructores:</p>
 * <ul>
 *   <li>{@link #Carrito()}: Constructor por defecto.</li>
 *   <li>{@link #Carrito(Cliente cliente)}: Constructor para inicializar el carrito con un cliente.</li>
 * </ul>
 * 
 * <p>Métodos:</p>
 * <ul>
 *   <li>{@link #toString()}: Devuelve una representación en cadena del carrito.</li>
 *   <li>{@link #getId()}: Devuelve el id del carrito.</li>
 *   <li>{@link #setId(Long id)}: Establece el id del carrito.</li>
 *   <li>{@link #getItems()}: Devuelve la lista de artículos en el carrito.</li>
 *   <li>{@link #setItems(List<Item> items)}: Establece la lista de artículos en el carrito, filtrando por el id del carrito.</li>
 *   <li>{@link #getTotal()}: Devuelve el costo total de los artículos en el carrito.</li>
 *   <li>{@link #setTotal()}: Calcula y establece el costo total de los artículos en el carrito.</li>
 *   <li>{@link #getComprado()}: Devuelve si el carrito ha sido comprado.</li>
 *   <li>{@link #setComprado(Boolean comprado)}: Establece si el carrito ha sido comprado.</li>
 *   <li>{@link #getCliente()}: Devuelve el cliente asociado con el carrito.</li>
 *   <li>{@link #setCliente(Cliente cliente)}: Establece el cliente asociado con el carrito.</li>
 *   <li>{@link #getOrden()}: Devuelve el pedido asociado con el carrito.</li>
 *   <li>{@link #setOrden()}: Crea y establece el pedido si el carrito ha sido comprado, de lo contrario lanza una excepción.</li>
 * </ul>
 */


@Getter
@Setter
@Entity
@Table(name = "carrito")
@Data
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonIgnore
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    @Column
    private Double total;

    @Column
    private Boolean comprado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "orden_id", referencedColumnName = "id")
    private Orden orden;

    public Carrito() {
    }

    public Carrito(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        setTotal();
        setComprado(false);
    }

    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", items=" + items +
                ", total=" + total +
                ", comprado=" + comprado +
                ", cliente=" + cliente +
                ", orden=" + orden +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        if (items != null) {
            this.items = items.stream().filter(item -> item.getCarrito().getId() == getId()).toList();
        } else {
            this.items = new ArrayList<>(); 
        }
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal() {
        if (this.items != null && !this.items.isEmpty()) {
            this.total = this.items.stream().mapToDouble(Item::getSubtotal).sum();
        } else {
            this.total = 0.0;
        }    
    }

    public Boolean getComprado() {
        return this.comprado;
    }

    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Orden getOrden() {
        return this.orden;
    }

    public void setOrden() {
        if (this.comprado) {
            this.orden = new Orden(this);
        } else {
            throw new IllegalArgumentException("El carrito debe estar marcado como comprado para crear una orden.");
        }
     }




}

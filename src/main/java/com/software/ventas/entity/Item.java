package com.software.ventas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an item in the ventas system.
 * This entity is mapped to the "item" table in the database.
 * It includes details about the product, the number of units, and the subtotal cost.
 * 
 * Annotations:
 * - @Entity: Specifies that the class is an entity and is mapped to a database table.
 * - @Table: Specifies the table name in the database.
 * - @Id: Specifies the primary key of an entity.
 * - @GeneratedValue: Provides the specification of generation strategies for the primary keys.
 * - @Column: Specifies the mapped column for a persistent property or field.
 * - @ManyToOne: Defines a many-to-one relationship between this entity and another.
 * - @JoinColumn: Specifies the foreign key column.
 * - @JsonIgnore: Indicates that the annotated field is to be ignored by Jackson during serialization and deserialization.
 * - @Getter and @Setter: Lombok annotations to generate getter and setter methods.
 * - @Data: Lombok annotation to generate boilerplate code like getters, setters, toString, etc.
 * 
 * Fields:
 * - id: The unique identifier for the item.
 * - unidades: The number of units of the product.
 * - subtotal: The subtotal cost for the item.
 * - producto: The product associated with the item.
 * - carrito: The shopping cart associated with the item.
 * 
 * Constructors:
 * - Item(): Default constructor.
 * - Item(Integer unidades, Producto producto, Carrito carrito): Parameterized constructor to create an item with specified units, product, and cart.
 * 
 * Methods:
 * - toString(): Returns a string representation of the item.
 * - getId(): Returns the id of the item.
 * - setId(Long id): Sets the id of the item.
 * - getUnidades(): Returns the number of units.
 * - setUnidades(Integer unidades): Sets the number of units and updates the subtotal.
 * - getProducto(): Returns the product associated with the item.
 * - setProducto(Producto producto): Sets the product associated with the item.
 * - getSubtotal(): Returns the subtotal cost.
 * - setSubtotal(): Calculates and sets the subtotal cost based on the product price and units.
 * - restarUnidades(): Deducts the units from the product if the cart is marked as purchased.
 * - getCarrito(): Returns the shopping cart associated with the item.
 * - setCarrito(Carrito carrito): Sets the shopping cart associated with the item.
 */

 

@Getter
@Setter
@Entity
@Table(name = "item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer unidades;

    @Column
    private Double subtotal;
    
    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "carrito_id", referencedColumnName = "id")
    private Carrito carrito;

    public Item() {
    }

    public Item(Integer unidades, Producto producto, Carrito carrito) {
        if (producto.unidadesDisponibles() && unidades <= producto.getUnidades()){
        this.producto = producto;
        setUnidades(unidades);
        setCarrito(carrito);
        setSubtotal();
        }
        else {
                throw new IllegalArgumentException("No hay unidades disponibles del producto");
            }
    }

    public String toString() {
        return "Item{" +
                "id=" + id +
                ", unidades=" + unidades +
                ", subtotal=" + subtotal +
                ", producto=" + producto +
                '}';
    }
    



    public Long getId(){
        return this.id;

    }

    public void setId(Long id){
        this.id = id;
    }

    public Integer getUnidades(){
        return this.unidades;
    }

    public void setUnidades(Integer unidades){
        if (this.producto.unidadesDisponibles()){
        this.unidades = unidades;
        setSubtotal();
        }
        else{
            System.out.println("No hay unidades disponibles del producto");
        }       
    }

    public Producto getProducto(){
        return this.producto;
    }

    public void setProducto(Producto producto){
        if(producto.unidadesDisponibles()){
            this.producto = producto;
        }
        else{            
            System.out.println("No hay unidades disponibles del producto");
        }
    }

    public Double getSubtotal(){
        return this.subtotal;
    }

    public void setSubtotal() {
        if(this.producto != null && this.producto.unidadesDisponibles()){
        this.subtotal = producto.getPrecio() * this.unidades;
    }
    }

    public void restarUnidades(){
        if(this.carrito.getComprado()){
            this.producto.setUnidades(this.producto.getUnidades() - this.unidades);
            }
        }

    public Carrito getCarrito(){
        return this.carrito;

        
    }

    public void setCarrito(Carrito carrito){
        this.carrito = carrito;
    }

}








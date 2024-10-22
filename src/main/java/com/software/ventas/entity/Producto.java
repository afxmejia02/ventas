package com.software.ventas.entity;

import com.software.ventas.entity.enums.Categoria;
import com.software.ventas.entity.enums.Genero;
import com.software.ventas.entity.enums.Talla;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a product entity in the ventas system.
 * This entity is mapped to the "producto" table in the database.
 * It includes various attributes such as id, name, price, image, description, units, gender, category, brand, and size.
 * 
 * Annotations:
 * - @Entity: Specifies that the class is an entity and is mapped to a database table.
 * - @Table(name = "producto"): Specifies the name of the database table to be used for mapping.
 * - @Id: Specifies the primary key of an entity.
 * - @GeneratedValue(strategy = GenerationType.IDENTITY): Provides the specification of generation strategies for the values of primary keys.
 * - @Column: Specifies the mapped column for a persistent property or field.
 * - @Enumerated(EnumType.STRING): Specifies that a persistent property or field should be persisted as a string representation of an enumerated type.
 * - @Getter and @Setter: Lombok annotations to generate getter and setter methods.
 * - @Data: Lombok annotation to generate boilerplate code such as getters, setters, toString, equals, and hashCode methods.
 * 
 * Attributes:
 * - id: The unique identifier for the product.
 * - nombre: The name of the product.
 * - Precio: The price of the product.
 * - imagen: The image URL of the product.
 * - descripcion: The description of the product.
 * - unidades: The number of units available for the product.
 * - genero: The gender category of the product 
 * - categoria: The category of the product 
 * - marca: The brand of the product.
 * - talla: The size of the product.
 * 
 * Methods:
 * - Producto(): Default constructor.
 * - Producto(Long id, String nombre, Double Precio, String imagen, String descripcion, Integer unidades, Genero genero, Categoria categoria, String marca, Talla talla): Parameterized constructor.
 * - toString(): Returns a string representation of the product.
 * - getId(): Returns the id of the product.
 * - setId(Long id): Sets the id of the product.
 * - getNombre(): Returns the name of the product.
 * - setNombre(String nombre): Sets the name of the product.
 * - getPrecio(): Returns the price of the product.
 * - setPrecio(Double Precio): Sets the price of the product.
 * - getImagen(): Returns the image URL of the product.
 * - setImagen(String imagen): Sets the image URL of the product.
 * - getDescripcion(): Returns the description of the product.
 * - setDescripcion(String descripcion): Sets the description of the product.
 * - getUnidades(): Returns the number of units available for the product.
 * - setUnidades(Integer unidades): Sets the number of units available for the product.
 * - unidadesDisponibles(): Checks if there are units available for the product.
 * - getGenero(): Returns the gender category of the product.
 * - setGenero(Genero genero): Sets the gender category of the product.
 * - getCategoria(): Returns the category of the product.
 * - setCategoria(Categoria categoria): Sets the category of the product.
 * - getMarca(): Returns the brand of the product.
 * - setMarca(String marca): Sets the brand of the product.
 * - getTalla(): Returns the size of the product.
 * - setTalla(Talla talla): Sets the size of the product.
 */

/**
 * Representa una entidad de producto en el sistema de ventas.
 * Esta entidad está mapeada a la tabla "producto" en la base de datos.
 * Incluye varios atributos como id, nombre, precio, imagen, descripción, unidades, género, categoría, marca y talla.
 * 
 * Anotaciones:
 * - @Entity: Especifica que la clase es una entidad y está mapeada a una tabla de base de datos.
 * - @Table(name = "producto"): Especifica el nombre de la tabla de la base de datos que se utilizará para el mapeo.
 * - @Id: Especifica la clave primaria de una entidad.
 * - @GeneratedValue(strategy = GenerationType.IDENTITY): Proporciona la especificación de estrategias de generación para los valores de las claves primarias.
 * - @Column: Especifica la columna mapeada para una propiedad o campo persistente.
 * - @Enumerated(EnumType.STRING): Especifica que una propiedad o campo persistente debe ser almacenado como una representación en cadena de un tipo enumerado.
 * - @Getter y @Setter: Anotaciones de Lombok para generar métodos getter y setter.
 * - @Data: Anotación de Lombok para generar código repetitivo como getters, setters, toString, equals y hashCode.
 * 
 * Atributos:
 * - id: El identificador único del producto.
 * - nombre: El nombre del producto.
 * - precio: El precio del producto.
 * - imagen: La URL de la imagen del producto.
 * - descripcion: La descripción del producto.
 * - unidades: El número de unidades disponibles para el producto.
 * - genero: La categoría de género del producto
 * - categoria: La categoría del producto 
 * - marca: La marca del producto.
 * - talla: La talla del producto.
 * 
 * Métodos:
 * - Producto(): Constructor por defecto.
 * - Producto(Long id, String nombre, Double precio, String imagen, String descripcion, Integer unidades, Genero genero, Categoria categoria, String marca, Talla talla): Constructor con parámetros.
 * - toString(): Devuelve una representación en cadena del producto.
 * - getId(): Devuelve el id del producto.
 * - setId(Long id): Establece el id del producto.
 * - getNombre(): Devuelve el nombre del producto.
 * - setNombre(String nombre): Establece el nombre del producto.
 * - getPrecio(): Devuelve el precio del producto.
 * - setPrecio(Double precio): Establece el precio del producto.
 * - getImagen(): Devuelve la URL de la imagen del producto.
 * - setImagen(String imagen): Establece la URL de la imagen del producto.
 * - getDescripcion(): Devuelve la descripción del producto.
 * - setDescripcion(String descripcion): Establece la descripción del producto.
 * - getUnidades(): Devuelve el número de unidades disponibles del producto.
 * - setUnidades(Integer unidades): Establece el número de unidades disponibles del producto.
 * - unidadesDisponibles(): Verifica si hay unidades disponibles del producto.
 * - getGenero(): Devuelve la categoría de género del producto.
 * - setGenero(Genero genero): Establece la categoría de género del producto.
 * - getCategoria(): Devuelve la categoría del producto.
 * - setCategoria(Categoria categoria): Establece la categoría del producto.
 * - getMarca(): Devuelve la marca del producto.
 * - setMarca(String marca): Establece la marca del producto.
 * - getTalla(): Devuelve la talla del producto.
 * - setTalla(Talla talla): Establece la talla del producto.
 */

 
@Getter
@Setter
@Entity
@Table(name = "producto")
@Data
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    private String nombre;

    @Column
    private Double Precio;

    @Column
    private String imagen;

    @Column
    private String descripcion;

    @Column
    private Integer unidades;

    @Enumerated(EnumType.STRING)
    @Column
    private Genero genero;

    @Enumerated(EnumType.STRING)
    @Column
    private Categoria categoria;
    

    @Column
    private String marca;

    @Enumerated(EnumType.STRING)
    @Column
    private Talla talla;


    public Producto() {
    }

    public Producto(Long id, String nombre, Double Precio, String imagen, String descripcion, Integer unidades, Genero genero, Categoria categoria, String marca, Talla talla) {
        this.id = id;
        this.nombre = nombre;
        this.Precio = Precio;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.genero = genero;
        this.categoria = categoria;
        this.marca = marca;
        this.talla = talla;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", Precio='" + getPrecio() + "'" +
            ", imagen='" + getImagen() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", unidades='" + getUnidades() + "'" +
            ", genero='" + getGenero() + "'" +
            ", categoria='" + getCategoria() + "'" +
            ", marca='" + getMarca() + "'" +
            ", talla='" + getTalla() + "'" +
            "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public boolean unidadesDisponibles(){
        return this.unidades > 0;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }


    
}

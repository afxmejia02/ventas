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
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", Precio=" + Precio + ", imagen=" + imagen + ", descripcion=" + descripcion + ", unidades=" + unidades + ", genero=" + genero + ", categoria=" + categoria + ", marca=" + marca + ", talla=" + talla + '}';
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

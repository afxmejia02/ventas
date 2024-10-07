package com.software.ventas.entity;


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








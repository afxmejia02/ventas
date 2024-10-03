package com.software.ventas.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orden")
@Data
public class Orden {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

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
        return this.cliente = this.getCarrito().getCliente().getNombre()+" "+this.getCarrito().getCliente().getApellidos();
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

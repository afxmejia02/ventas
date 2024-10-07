package com.software.ventas.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carrito")
@Data
public class Carrito {

    //Cliente cliente;
    //Item item;
    //boolean comprado;
    //double total;
    //double subtotal;
    //private Long id;
    //Orden orden

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Transient
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
            this.items = new ArrayList<>(); // Si es nulo, inicializa una lista vacía
        }
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal() {
        this.total = this.items.stream().mapToDouble(Item::getSubtotal).sum();
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

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



//hereda los atributos de la superclase usuario
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

    //constructor de la clase Administrador
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

    //Metodos de la clase Administrador
    //Metodo para obtener el id del administrador
    public Long getId() {
        return id;
    }

    //Metodo para asignar el id del administrador
    public void setId(Long id) {
        this.id = id;
    }

    //Metodo para obtener el nombre del administrador
    @Override
    public String getNombre() {
        return super.getNombre();
    }

    //Metodo para asignar el nombre del administrador
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    //Metodo para obtener la contraseña del administrador
    @Override
    public String getHashcontraseña() {
        return super.getHashcontraseña();
    }

    //Metodo para asignar la contraseña hasheada del administrador
    @Override
    public void setHashcontraseña(String contraseña) {
        super.setHashcontraseña(contraseña);
    }

    //Metodo para verificar la contraseña del administrador
    @Override
    public boolean verificarContraseña(String contraseña) {
        return super.verificarContraseña(contraseña);
    }

    
}

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

//hereda los atributos de la superclase usuario
//Anotaciones necesarias para la creacion de la tabla en la base de datos
//Creacion de la tabla cliente
@Getter
@Setter
@Entity
@Table(name = "cliente")
@Data
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario{

    //Atributos de la clase Cliente
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

    //constructor de la clase Cliente
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

//Metodos de la clase Cliente

//Metodo para obtener el id del cliente
    public Long getId() {
        return this.id;
    }

    //Metodo para asignar el id del cliente
    public void setId(Long id) {
        this.id = id;
    }

    //Metodo para obtener el nombre del cliente
    @Override
    public String getNombre() {
        return super.getNombre();
    }
    
    //Metodo para asignar el nombre de usuario del cliente
    @Override
    public void setNombre(String nombre_usuario) {
        super.setNombre(nombre_usuario);
    }
    
    //Metodo para obtener la contraseña del cliente
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

package com.software.ventas.entity;

//importamos las librerias necesarias
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//Anotaciones necesarias para la creacion de la tabla en la base de datos
//Clase abstracta Usuario
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {


    //Atributos de la clase Usuario
    
    private String nombre_usuario;
    private String hashcontraseña;
    
    public Usuario(Long id, String nombre, String contraseña) {
        this.nombre_usuario = nombre;
        this.hashcontraseña = new BCryptPasswordEncoder().encode(contraseña);
    }
    


    public String getNombre() {
        return nombre_usuario;
    }

    //Metodo para asignar el nombre del usuario
    public void setNombre(String nombre) {
        this.nombre_usuario = nombre;
    }

    //Metodo para obtener la contraseña del usuario
    public String getHashcontraseña() {
        return hashcontraseña;
    }

    //Metodo para asignar la contraseña hasheada del usuario
    public void setHashcontraseña(String contraseña) {
        this.hashcontraseña = new BCryptPasswordEncoder().encode(contraseña);
    }

    public boolean verificarContraseña(String contraseña) {
        return new BCryptPasswordEncoder().matches(contraseña, this.hashcontraseña);
    }


}

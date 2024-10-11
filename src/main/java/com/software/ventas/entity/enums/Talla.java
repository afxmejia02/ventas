package com.software.ventas.entity.enums;

/**
 * Enum representing different shoe sizes.
 * Each enum constant corresponds to a specific shoe size.
 */

/**
 * Enumeración que representa diferentes tallas de zapatos.
 * Cada constante de enumeración corresponde a una talla específica de zapato.
  */ 

public enum Talla {
    
    T35("35"),
    T36("36"),
    T37("37"),
    T38("38"),
    T39("39"),
    T40("40"),
    T41("41"),
    T42("42"),
    T43("43");

    private final String numero;

    Talla(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }    


}

package com.software.ventas.entity.enums;

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

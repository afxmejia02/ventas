package com.software.ventas.entity.enums;


//generame un enum  de tipo documento

public enum TipoDocumento {
    
    TI("Tarjeta de identidad"),
    CC("Cédula de ciudadanía"),
    TE("Tarjeta de extranjería"),
    CE("Cédula de extranjería"),
    NIT("Número de identificación tributaria"),
    PP("Pasaporte");

    private final String descripcion;

    TipoDocumento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}



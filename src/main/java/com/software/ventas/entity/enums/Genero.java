package com.software.ventas.entity.enums;




public enum Genero {
    M("Masculino"),
    F("Femenino"),
    U("Unisex");

    private final String descripcion;

    Genero(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

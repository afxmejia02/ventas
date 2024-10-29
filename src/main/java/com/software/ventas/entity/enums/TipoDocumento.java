
package com.software.ventas.entity.enums;

/**
 * Enum representing different types of documents.
 * Each enum constant has a description associated with it.
 * 
 * <ul>
 *   <li>TI - Tarjeta de identidad</li>
 *   <li>CC - Cédula de ciudadanía</li>
 *   <li>TE - Tarjeta de extranjería</li>
 *   <li>CE - Cédula de extranjería</li>
 *   <li>NIT - Número de identificación tributaria</li>
 *   <li>PP - Pasaporte</li>
 * </ul>
 * 
 * Each enum constant has a description that can be retrieved using the {@link #getDescripcion()} method.
 */


/**
 * Enumeración que representa diferentes tipos de documentos.
 * Cada constante de enumeración tiene una descripción asociada.
 * 
 * <ul>
 *  <li>TI - Tarjeta de identidad</li>
 * <li>CC - Cédula de ciudadanía</li>
 * <li>TE - Tarjeta de extranjería</li>
 * <li>CE - Cédula de extranjería</li>
 * <li>NIT - Número de identificación tributaria</li>
 * <li>PP - Pasaporte</li>
 * </ul>
 * 
 * Cada constante de enumeración tiene una descripción que se puede recuperar utilizando el método {@link #getDescripcion()}.
 */

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




package com.software.ventas.entity.enums;

/**
 * Enum representing gender categories.
 * <p>
 * This enum provides three gender categories:
 * <ul>
 *   <li>{@link #M} - Masculino (Male)</li>
 *   <li>{@link #F} - Femenino (Female)</li>
 *   <li>{@link #U} - Unisex</li>
 * </ul>
 * Each category has a description associated with it.
 * </p>
 */


/**
 * Enumeración que representa categorías de género.
 * <p>
 * Esta enumeración proporciona tres categorías de género:
 * <ul>
 *   <li>{@link #M} - Masculino</li>
 *   <li>{@link #F} - Femenino</li>
 *   <li>{@link #U} - Unisex</li>
 * </ul>
 * Cada categoría tiene una descripción asociada.
 * </p>
 */

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

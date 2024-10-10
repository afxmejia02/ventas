package com.software.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.ventas.entity.Producto;
import com.software.ventas.entity.enums.Categoria;
import com.software.ventas.entity.enums.Genero;
import com.software.ventas.entity.enums.Talla;
import com.software.ventas.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> findByNombre(String nombre) {
        return productoRepository.findByName(nombre);
    }

    public List<Producto> findByCategoria(String categoria_str) {
        try {
            Categoria categoria = Categoria.valueOf(categoria_str);
            return productoRepository.findByCategoria(categoria);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoría inválida: " + categoria_str);
        }
    }

    public List<Producto> findByGenero(String genero_str) {
        try{
            Genero genero = Genero.valueOf(genero_str);
            return productoRepository.findByGenero(genero);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Género inválido: " + genero_str);
        }
    }

    public List<Producto> findByTalla(String talla_str) {
        try {
            Talla talla = Talla.valueOf("T" + talla_str);
            return productoRepository.findByTalla(talla);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Talla inválida: " + talla_str);
        }
    }

    public Producto create(Producto producto, String talla_str) {
        try {
            Talla talla = Talla.valueOf("T" + talla_str);
            producto.setTalla(talla);        
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Talla inválida: " + talla_str);
        }
        return productoRepository.save(producto);
    }

    public Producto updateById(Long id, Producto producto, String talla_str) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        Producto productoActualizado = productoOptional.get();
        productoActualizado.setNombre(producto.getNombre());
        productoActualizado.setDescripcion(producto.getDescripcion());
        productoActualizado.setPrecio(producto.getPrecio());
        productoActualizado.setCategoria(producto.getCategoria());
        productoActualizado.setGenero(producto.getGenero());
        productoActualizado.setUnidades(producto.getUnidades());
        try {
                Talla talla = Talla.valueOf("T" + talla_str);
                productoActualizado.setTalla(talla);        
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Talla inválida: " + talla_str);
            }            
            productoActualizado.setImagen(producto.getImagen());
            return productoRepository.save(productoActualizado);      
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }


    
}

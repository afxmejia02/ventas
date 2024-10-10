package com.software.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.ventas.entity.Producto;
import com.software.ventas.service.ProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable Long id) {
        return productoService.findById(id).get();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Producto> findByNombre(@PathVariable String nombre) {
        return productoService.findByNombre(nombre);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> findByCategoria(@PathVariable String categoria) {
        return productoService.findByCategoria(categoria);
    }

    @GetMapping("/genero/{genero}")
    public List<Producto> findByGenero(@PathVariable String genero) {
        return productoService.findByGenero(genero);
    }

    @GetMapping("/talla/{talla}")
    public List<Producto> findByTalla(@PathVariable String talla) {
        return productoService.findByTalla(talla);
    }

    @PostMapping("/create")
    public Producto create(@RequestBody Producto producto, @RequestParam String talla) {
        return productoService.create(producto, talla);
    }

    @PutMapping("/update/{id}")
    public Producto updateById(@PathVariable Long id, @RequestBody Producto producto, @RequestParam String talla) {
        return productoService.updateById(id, producto, talla);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productoService.deleteById(id);
    }



    
}

package com.tanguito.demo.controllers;

import com.tanguito.demo.entity.Producto;
import com.tanguito.demo.services.ProductService;
import com.tanguito.demo.services.implementacion.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping("/productos")
    public List<Producto> listarProductos(){
        List<Producto> productos = productoService.listarProductos();
        System.out.println("Productos obtenidos de la BD: " + productos); // Depuración
        return productos;
    }

    @GetMapping("/producto/{id_producto}")
    public Producto obtenerProductoPorId(@PathVariable("id_producto") int id_producto){
        return productoService.obtenerProducto(id_producto);
    }

    @PostMapping("/producto/guardar-producto")
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/producto/{id_producto}")
    public Producto actualizarProducto(@PathVariable("id_producto")int idPrducto, @RequestBody Producto producto){
        Producto productoExistente= productoService.obtenerProducto(idPrducto);
        if(productoExistente!=null){
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setCantidad(producto.getCantidad());
            return productoService.guardarProducto(productoExistente);
        }
        return null;
    }

    @DeleteMapping("producto/{id_producto}")
    public  void borrarProducto(@PathVariable("id_producto") int idProducto){
        productoService.eliminatProducto(idProducto);
    }



}

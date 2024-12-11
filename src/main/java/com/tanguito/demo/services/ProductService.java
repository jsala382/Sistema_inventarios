package com.tanguito.demo.services;

import com.tanguito.demo.entity.Producto;
import java.util.List;

public interface ProductService {
    public List<Producto> listarProductos();
    public Producto obtenerProducto(Integer idProdutco);
    public Producto guardarProducto(Producto producto);
    public void eliminatProducto(Integer idProducto);
}

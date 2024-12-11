package com.tanguito.demo.services.implementacion;

import com.tanguito.demo.entity.Producto;
import com.tanguito.demo.repositoy.ProductRepository;
import com.tanguito.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Producto> listarProductos() {
        return productRepository.findAll();
    }

    @Override
    public Producto obtenerProducto(Integer idProdutco) {
        return productRepository.findById(idProdutco).orElse(null);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productRepository.save(producto);
    }

    @Override
    public void eliminatProducto(Integer idProducto) {
         productRepository.deleteById(idProducto);
    }
}

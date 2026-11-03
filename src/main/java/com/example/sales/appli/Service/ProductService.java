package com.example.sales.appli.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.sales.appli.Entity.Product;
import com.example.sales.appli.Repository.ProductRepository;


@Service 
public class ProductService {

    @Autowired  ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        productRepository.delete(product);
    }

    public Product updateProduct(Long id, Product updatedProduct){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        product.setSalesName(updatedProduct.getSalesName());
        product.setPrice(updatedProduct.getPrice());
        product.setNoofsales(updatedProduct.getNoofsales());
        return productRepository.save(product);
    }
}

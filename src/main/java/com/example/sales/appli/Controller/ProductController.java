package com.example.sales.appli.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sales.appli.Entity.Product;
import com.example.sales.appli.Service.ProductService;


@RestController 
public class ProductController {

    @Autowired ProductService productService;
    
   @PostMapping ("/create")
   public Product createProduct(@RequestBody Product product){
     return productService.createProduct(product);
   }

   @GetMapping ("/getAll")
   public List<Product> getAllProduct(){
     return productService.getAllProduct();
   }

    @GetMapping ("/get/{id}")
     public Product findProductById(@PathVariable Long id){
     return productService.findProductById(id);
   }

   @DeleteMapping ("/delete/{id}")
   public void deleteProduct(@PathVariable Long id){
     productService.deleteProduct(id);
   }

   @PutMapping ("/update/{id}")
   public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
     return productService.updateProduct(id, product);
   }
}
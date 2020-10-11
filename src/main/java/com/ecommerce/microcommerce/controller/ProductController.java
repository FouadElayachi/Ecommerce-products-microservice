package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.module.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "products")
    public List<Product> productList() {
        return productDao.findAll();
    }

    @GetMapping(value = "products/{id}")
    public Product showProduct(@PathVariable int id) {
        return productDao.findById(id);
    }

    @PostMapping(value = "products")
    public void addProduct(@RequestBody Product product) {
        productDao.save(product);
    }
}

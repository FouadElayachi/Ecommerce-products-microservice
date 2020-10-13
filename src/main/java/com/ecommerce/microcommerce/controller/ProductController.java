package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.exceptions.ProductNotFoundException;
import com.ecommerce.microcommerce.module.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        Product product = productDao.findById(id);

        if(product == null) throw new ProductNotFoundException("Test");

        return product;
    }

    @PostMapping(value = "products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
        Product productAdded = productDao.save(product);

        if(productAdded == null) {
            return ResponseEntity.noContent().build();
        }

        //Create the URI of the new product
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "products/greater/{priceLimit}")
    public List<Product> getProductsGreaterThanPrice(@PathVariable double priceLimit) {
        return productDao.searchProductGreaterThanLimitPrice(priceLimit);
    }
}

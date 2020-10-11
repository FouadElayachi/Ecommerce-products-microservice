package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.module.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> findAll();

    public Product findById(int id);

    public Product save(Product product);
}

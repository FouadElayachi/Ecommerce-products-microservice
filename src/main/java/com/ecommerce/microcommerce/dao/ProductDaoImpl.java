package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.module.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Phone", 160));
        products.add(new Product(2, "PS5", 8000));
        products.add(new Product(3, "Laptop", 9000));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for(Product product: products) {
            if(product.getId() == id) return product;
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}

package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findById(int id);

    List<Product> findByPriceGreaterThan(double price);
}

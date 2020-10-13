package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findById(int id);

    List<Product> findByPriceGreaterThan(double price);

    //Manual query
    @Query("SELECT p FROM Product p WHERE p.price > :priceLimit")
    List<Product> searchProductGreaterThanLimitPrice(@Param("priceLimit") double price);
}

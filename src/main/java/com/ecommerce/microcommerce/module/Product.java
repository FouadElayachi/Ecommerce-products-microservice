package com.ecommerce.microcommerce.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@JsonIgnoreProperties(value = {"purchasePrice"})
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    //Hidden variable
    private double purchasePrice;

    public Product(int id, String name, double price, double purchasePrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.purchasePrice = purchasePrice;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", purchasePrice=" + purchasePrice +
                '}';
    }
}

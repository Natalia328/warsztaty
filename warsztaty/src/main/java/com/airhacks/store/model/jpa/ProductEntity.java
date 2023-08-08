package com.airhacks.store.model.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public ProductEntity() {

    }
    public void buyProduct(int id) {
        quantity -=1;
    }
    @Override
    public String toString() {
        return  productName +
                " cena=" + price +
                " zł, dostępna ilość=" + quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity(int id, String productName, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
}

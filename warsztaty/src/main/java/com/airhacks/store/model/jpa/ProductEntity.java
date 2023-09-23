package com.airhacks.store.model.jpa;

import com.airhacks.store.model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {
    public ProductEntity(Long id, String productName, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductEntity() {
    }

    @Id
    private Long id;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Collection<OrdersEntity> ordersEntities;

    public Collection<OrdersEntity> getOrdersEntities() {
        return ordersEntities;
    }

    public void setOrdersEntities(Collection<OrdersEntity> ordersEntities) {
        this.ordersEntities = ordersEntities;
    }

    @Override
    public String toString() {
        return  productName +
                " cena=" + price +
                " zł, dostępna ilość=" + quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}

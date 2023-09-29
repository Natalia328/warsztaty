package com.airhacks.store.model.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {
    public ProductEntity(Long id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public ProductEntity() {
    }

    @Id
    private Long id;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private double price;

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
                "<br>" + price +
                " zł";
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

}

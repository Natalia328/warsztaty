package com.airhacks.store.model.jpa;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "orderDate", nullable = false)
    private String orderDate;


    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @ManyToOne(targetEntity = ProductEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Użytkownik: " + user.getEmail() + "<br>" +
                "Data zamówienia= " + orderDate + "<br>" +
                product.getProductName();
    }
}

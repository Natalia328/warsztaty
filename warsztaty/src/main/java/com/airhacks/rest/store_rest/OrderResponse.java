package com.airhacks.rest.store_rest;


public class OrderResponse {
    private Long id;
    private String orderDate;
    private UserDTO user;
    private ProductDTO product;

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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ProductDTO getProduct() { return product; }

    public void setProduct(ProductDTO product) { this.product = product; }

}

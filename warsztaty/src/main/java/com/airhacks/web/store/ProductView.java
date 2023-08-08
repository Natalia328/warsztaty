package com.airhacks.web.store;


import com.airhacks.store.dao.ProductDao;
import com.airhacks.store.dao.UserDao;
import com.airhacks.store.model.jpa.ProductEntity;
import com.airhacks.store.model.jpa.UserEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class ProductView implements Serializable {
    private int id;

    private String productName;

    private double price;

    private int quantity;

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

    @Inject
    private ProductDao productDao;

    public String showProduct(int id) {
        ProductEntity product = productDao.getProduct(id);
        return product.toString();
    }

    public String buyProduct(int id) {
        ProductEntity product = productDao.getProduct(id);
        product.setQuantity(getQuantity()-1);
        return product.toString();
    }

}

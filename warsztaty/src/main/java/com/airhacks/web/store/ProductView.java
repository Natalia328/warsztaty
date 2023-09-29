package com.airhacks.web.store;


import com.airhacks.store.dao.ProductDao;
import com.airhacks.store.model.jpa.ProductEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProductView implements Serializable {

    @Inject
    private ProductDao productDao;

    private Long id;

    private String productName;

    private double price;

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



    public String showProductName(Long id) {
        ProductEntity product = productDao.getProduct(id);
        return product.getProductName();
    }
    public String showProductPrice(Long id) {
        ProductEntity product = productDao.getProduct(id);
        return product.getPrice() + " zł";
    }
    
    public String showProducts() {
        List<ProductEntity> products = productDao.getProducts();
        StringBuilder builder = new StringBuilder();
        for (ProductEntity product : products) {
            builder.append("<p class=\"itemFromList\">" + product+ "</p>");
        }
        return builder.toString();
    }

}

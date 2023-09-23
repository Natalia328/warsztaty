package com.airhacks.web.store;


import com.airhacks.store.dao.ProductDao;
import com.airhacks.store.model.SessionUtils;
import com.airhacks.store.model.jpa.ProductEntity;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
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

    private int quantity;

//    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
//    public void setNew() {
//        ProductEntity p14 = new ProductEntity(1L, "Książka kucharska", 49.99, 100);
//        productDao.addNewProduct(p14);
//        ProductEntity p2 = new ProductEntity(2L, "Przewodnik górski", 59.99, 100);
//        productDao.addNewProduct(p2);
//    }

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


    public String showProduct(Long id) {
        ProductEntity product = productDao.getProduct(id);
        return product.toString();
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

package com.airhacks.web.store;

import com.airhacks.rest.store_rest.OrderRequest;
import com.airhacks.rest.store_rest.UserRequest;
import com.airhacks.store.dao.OrdersDao;
import com.airhacks.store.dao.UserDao;
import com.airhacks.store.model.SessionUtils;
import com.airhacks.store.model.jpa.OrdersEntity;
import com.airhacks.store.model.jpa.ProductEntity;
import com.airhacks.store.model.jpa.UserEntity;
import com.airhacks.store.service.OrderService;
import com.airhacks.store.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

@Named
@SessionScoped
public class AddOrderView implements Serializable {

    @Inject
    private OrderService orderService;
    @Inject
    private OrderRequest orderRequest;
    @Inject
    private OrdersDao ordersDao;
    private String orderDate;
    private UserEntity user;
    private ProductEntity product;

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }


//    to nie działa!!! do poprawki

    public String buyProduct(Long productId) {
        orderRequest.setOrderDate(orderDate);
        orderRequest.setProductId(productId);
        orderRequest.setUserId(38L);
        orderService.addNewOrder(orderRequest);
        return "productBought";
    }

    public String showOrders() {
        List<OrdersEntity> orders = ordersDao.getOrders();
        StringBuilder builder = new StringBuilder();
        for (OrdersEntity order : orders) {
            builder.append("<p class= \"itemFromList\">" + order+ "</p>");
        }
        return builder.toString();
    }

//    public String showOrdersByUserId(Long id) {
//        List<OrdersEntity> orders = ordersDao.getOrdersByUserId(id);
//        StringBuilder builder = new StringBuilder();
//        for (OrdersEntity order : orders) {
//            builder.append("<p>" + order+ "</p>");
//            builder.append("<br/>");
//        }
//        return builder.toString();
//    }
}

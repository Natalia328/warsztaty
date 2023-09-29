package com.airhacks.web.store;

import com.airhacks.rest.store_rest.OrderRequest;
import com.airhacks.store.dao.OrdersDao;
import com.airhacks.store.model.SessionUtils;
import com.airhacks.store.model.jpa.OrdersEntity;
import com.airhacks.store.model.jpa.ProductEntity;
import com.airhacks.store.model.jpa.UserEntity;
import com.airhacks.store.service.OrderService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@ManagedBean
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

    public Long showUserIDSession() {
        HttpSession session = SessionUtils.getSession();
        Long userID = SessionUtils.getUserID();
        return userID;
    }

    public String buyProduct(Long productId) {
        orderRequest.setOrderDate(orderDate);
        orderRequest.setProductId(productId);
        Long loggedUserID = showUserIDSession();
        orderRequest.setUserId(loggedUserID);
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
}

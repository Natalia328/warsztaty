package com.airhacks.web.store;

import com.airhacks.rest.store_rest.OrderRequest;
import com.airhacks.store.dao.OrdersDao;
import com.airhacks.store.dao.ProductDao;
import com.airhacks.store.dao.UserDao;
import com.airhacks.store.model.HibernateUtil;
import com.airhacks.store.model.ProductList;
import com.airhacks.store.model.SessionUtils;
import com.airhacks.store.model.jpa.OrdersEntity;
import com.airhacks.store.model.jpa.ProductEntity;
import com.airhacks.store.model.jpa.UserEntity;
import com.airhacks.store.service.OrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;
import javax.inject.Inject;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class LogInView implements Serializable {


    @Inject
    private UserDao userDao;
    @Inject
    private ProductDao productDao;
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String checkIfUserExist(){

            List<UserEntity> userExist = userDao.isUserExist(email, password);
            if (userExist.size() == 1) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("email", email);

                if(email.equals("admin@admin.pl") && password.equals("admin")) {
                    return "adminPanel";
                } else {
                    return "userExists";
                }
            } else{
                FacesContext.getCurrentInstance().addMessage(
                        "loginForm",
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Incorrect Username and Password",
                                "Niestety, nie możemy znaleźć konta z tym adresem e-mail. Spróbuj ponownie lub utwórz nowe konto."));
                return "logInPage";
            }
    }

    public String showLoggedUser() {
        UserEntity userByEmail = userDao.getUserByEmail(email);
        return userByEmail.getFirstName() + "!";

    }
    public Long takeCurrentUserId() {
        UserEntity userByEmail = userDao.getUserByEmail(email);
        return userByEmail.getId();
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "welcomePage";
    }

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



    public String buyProduct(Long productId) {
        orderRequest.setOrderDate(orderDate);
        orderRequest.setProductId(productId);
        orderRequest.setUserId(takeCurrentUserId());
        orderService.addNewOrder(orderRequest);
        return "productBought";
    }

    public String showOrders() {
        List<OrdersEntity> orders = ordersDao.getOrders();
        StringBuilder builder = new StringBuilder();
        for (OrdersEntity order : orders) {
            builder.append("<p>" + order+ "</p>");
            builder.append("<br/>");
        }
        return builder.toString();
    }


}

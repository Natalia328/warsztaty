package com.airhacks.web.store;

import com.airhacks.store.dao.UserDao;
import com.airhacks.store.model.ProductList;
import com.airhacks.store.model.jpa.UserEntity;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;
import javax.inject.Inject;
import java.io.Serializable;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.logging.Logger;

@ManagedBean
@RequestScoped
public class LogInView implements Serializable {


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


    @Inject
    private UserDao userDao;


    public String checkIfUserExist() {
            List<UserEntity> userExist = userDao.isUserExist(email, password);
            if (userExist.size() == 1) {
                return "userExists";
            } else
                return "noUser";

    }

    public String showLoggedUser() {
        UserEntity userByEmail = userDao.getUserByEmail(email);
        return userByEmail.getFirstName() + "!";
    }
}

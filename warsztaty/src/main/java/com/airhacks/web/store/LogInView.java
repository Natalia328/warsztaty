package com.airhacks.web.store;

import com.airhacks.store.dao.UserDao;
import com.airhacks.store.model.SessionUtils;
import com.airhacks.store.model.jpa.UserEntity;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LogInView implements Serializable {

    private final static String ADMIN_PASSWORD= "admin";
    private final static String ADMIN_MAIL= "admin@admin.pl";

    @Inject
    private UserDao userDao;
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

    public String checkIfUserExist() {

        List<UserEntity> userExist = userDao.isUserExist(email, password);
        if (userExist.size() == 1) {
            HttpSession session = SessionUtils.getSession();
            Long userSessionID = userExist.get(0).getId();
            session.setAttribute("userSessionID", userSessionID);

            if (email.equals(ADMIN_MAIL) && password.equals(ADMIN_PASSWORD)) {
                return "adminPanel";
            } else {
                return "userExists";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    "loginForm",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Password",
                            "Niestety, nieprawidłowe hasło lub dany adres e-mail nie posiada konta. Spróbuj ponownie lub utwórz nowe konto."));
            return "logInPage";
        }
    }

    public String showLoggedUser() {
        UserEntity userByEmail = userDao.getUserByEmail(email);
        return userByEmail.getFirstName() + "!";

    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "welcomePage";
    }
}


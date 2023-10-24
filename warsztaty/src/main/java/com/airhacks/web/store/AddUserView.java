package com.airhacks.web.store;

import com.airhacks.rest.store_rest.UserRequest;
import com.airhacks.store.dao.UserDao;
import com.airhacks.store.model.jpa.UserEntity;
import com.airhacks.store.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class AddUserView implements Serializable{

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Inject
    private UserService userService;
    @Inject
    private UserRequest userRequest;
    @Inject
    private UserDao userDao;

    public String addUserItem(){
        boolean emailExist = checkIfEmailExistInDB();
        if (!emailExist) {
            userRequest.setFirstName(firstName);
            userRequest.setLastName(lastName);
            userRequest.setEmail(email);
            userRequest.setPassword(password);
            userService.addUser(userRequest);
            return "signInCompleted";
        }
        else
            return "signInPage";
    }

    public boolean checkIfEmailExistInDB(){
        List<UserEntity> userExist = userDao.isEmailExist(email);
        if (userExist.size() == 1) {
            FacesContext.getCurrentInstance().addMessage(
                    "signinForm",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Given Email address exist in database",
                            "Podany adres e-mail istnieje już w bazie"));
            return true;
        } else
            return false;
    }

    public String showUsers() {
        List<UserEntity> users = userDao.getUsers();
        StringBuilder builder = new StringBuilder();
        for (UserEntity user : users) {
            builder.append("<p class=\"itemFromList\">" + user+ "</p>");
        }
        return builder.toString();
    }

    }



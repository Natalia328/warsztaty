package com.airhacks.web.store;

import com.airhacks.rest.store_rest.UserRequest;
import com.airhacks.store.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

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

        public String addUserItem(){
            userRequest.setFirstName(firstName);
            userRequest.setLastName(lastName);
            userRequest.setEmail(email);
            userRequest.setPassword(password);
            userService.addUser(userRequest);
            return "signInCompleted";
        }

    }



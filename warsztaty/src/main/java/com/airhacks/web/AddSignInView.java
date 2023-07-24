package com.airhacks.web;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class AddSignInView  implements Serializable {

    public String signIn(){
        return "signin";
    }
}

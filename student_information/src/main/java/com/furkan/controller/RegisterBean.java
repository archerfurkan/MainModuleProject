package com.furkan.controller;

import com.furkan.model.User;
import com.furkan.service.LoginService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "register")
public class RegisterBean {
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private User.Role role;
    private User user;

    @EJB
    LoginService loginService;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}

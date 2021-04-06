package com.furkan.controller;

import com.furkan.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "register")
public class RegisterBean {
    private User user;
    private String password2;
    private List<SelectItem> roleList;

    @PostConstruct
    public void init(){
        user = new User();
        roleList = new ArrayList<>();
        User.Role[] roleArr = User.Role.values();

        for (User.Role role : roleArr) {
            roleList.add(new SelectItem(role));
        }
    }

    public String registerUser(){

        return "register";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public List<SelectItem> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SelectItem> roleList) {
        this.roleList = roleList;
    }
}


package com.furkan.controller;

import com.furkan.model.User;
import com.furkan.service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
public class UserListBean {

    private List<User> userList;

    @EJB
    private UserService userService;

    @PostConstruct
    public void init(){
        userList = userService.getAllUsers();
    }

    public String deleteUser(User user){
        userService.deleteUserOnDB(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Delete User", "user is deleted"));
        return "userlist?faces-redirect=true";
    }


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

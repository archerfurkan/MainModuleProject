package com.furkan.controller;

import com.furkan.model.User;
import com.furkan.service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class UpdateUserBean {
    private User user;
    private List<SelectItem> roleList;

    @EJB
    private UserService userService;


    @PostConstruct
    public void init() {
        roleList = new ArrayList<>();
        User.Role[] roleArr = User.Role.values();
        for (User.Role role : roleArr) {
            roleList.add(new SelectItem(role));
        }
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        int userId = Integer.parseInt(req.getParameter("userId"));
        user = userService.findUser(userId);

    }

    public String updateUser() {
        userService.updateUser(this.user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Update User", "user is Updated"));
        return "updateuser?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SelectItem> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SelectItem> roleList) {
        this.roleList = roleList;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

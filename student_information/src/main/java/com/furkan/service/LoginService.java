package com.furkan.service;

import com.furkan.model.User;
import com.furkan.utils.HashAlgorithm;
import com.furkan.utils.SecurityUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class LoginService {
    @PersistenceContext
    EntityManager entityManager;


    public boolean checkUserOnDB(String email, String password) {
        TypedQuery<User> query = entityManager.createQuery("from User u where email=:email and password=:password",User.class);
        query.setParameter("email",email);
        query.setParameter("password", SecurityUtils.hassPassword(password, HashAlgorithm.SHA256).toString());
        List<User> result = query.getResultList();

        boolean isExist = result.size()>0?true:false;
        return isExist;
    }

    public User getUser(String email, String password) {

        TypedQuery<User> query = entityManager.createQuery("from User u where email=:email and password=:password",User.class);
        query.setParameter("email",email);
        query.setParameter("password", SecurityUtils.hassPassword(password, HashAlgorithm.SHA256).toString());
        List<User> result = query.getResultList();

        return result.get(0);
    }
}

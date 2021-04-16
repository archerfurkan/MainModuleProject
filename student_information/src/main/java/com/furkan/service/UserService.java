package com.furkan.service;

import com.furkan.model.User;
import com.furkan.utils.HashAlgorithm;
import com.furkan.utils.SecurityUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserService {

    @PersistenceContext
    EntityManager entityManager;

    public void registerUserToDatabase(User user){
        user.setPassword(SecurityUtils.hassPassword(user.getPassword(), HashAlgorithm.SHA256).toString());
        entityManager.persist(user);

    }


    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User",User.class).getResultList();
    }

    public void deleteUserOnDB(User user) {
        User foundUser =  entityManager.find(User.class,user.getId());
        entityManager.remove(foundUser);
    }

    public User findUser(int userId) {
        return entityManager.find(User.class , userId);

    }


    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public boolean isEmailExistOnDB(String email) {
       List<User> userList = entityManager.createQuery("from User u where u.email=:email ",User.class).setParameter("email",email).getResultList();
        return userList.size() > 0;
    }
}

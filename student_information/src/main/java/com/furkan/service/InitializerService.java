package com.furkan.service;

import com.furkan.model.Course;
import com.furkan.model.User;
import com.furkan.utils.HashAlgorithm;
import com.furkan.utils.SecurityUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class InitializerService {
    @PersistenceContext
    EntityManager entityManager;

    private static final Logger logger = Logger.getLogger(InitializerService.class);



    public void saveTestUserAndCourseData() {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);

        List<User> userList = entityManager.createQuery("from User ",User.class).getResultList();
        if(userList.size() == 0) {

            User user1 = new User("Kaan", "Keskin", "kaan@aaa.com", SecurityUtils.hassPassword("1234", HashAlgorithm.SHA256).toString(), User.Role.ADMIN);
            User user2 = new User("Furkan", "Okcu", "furkan@aaa.com", SecurityUtils.hassPassword("1234", HashAlgorithm.SHA256).toString(), User.Role.STUDENT);
            User user3 = new User("Oguzhan", "Olgun", "oguzhan@aaa.com", SecurityUtils.hassPassword("1234", HashAlgorithm.SHA256).toString(), User.Role.INSTRUCTOR);
            User user4 = new User("Sefa", "Yıldırım", "sefa@aaa.com", SecurityUtils.hassPassword("1234", HashAlgorithm.SHA256).toString(), User.Role.STUDENT);
            User user5 = new User("Koray", "Guney", "koray@aaa.com", SecurityUtils.hassPassword("1234", HashAlgorithm.SHA256).toString(), User.Role.ADMIN);

            entityManager.persist(user1);
            entityManager.persist(user2);
            entityManager.persist(user3);
            entityManager.persist(user4);
            entityManager.persist(user5);
        }
        List<Course> courses = entityManager.createQuery("from Course ",Course.class).getResultList();
        if(userList.size() == 0) {
            Course course1 = new Course("IT535", "Introduction to java programing");
            Course course2 = new Course("IT510", "Artificial Intelegance");
            Course course3 = new Course("IT535", "Programing with python");

            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);
        }

        logger.info("all test data inserted to db...");

    }
}

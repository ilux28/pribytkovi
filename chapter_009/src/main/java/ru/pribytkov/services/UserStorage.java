package ru.pribytkov.services;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.User;

import java.util.List;


public class UserStorage {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        for (User user : users)
            System.out.println(user.getName());
        session.getTransaction().commit();
        session.close();
        factory.close();
        //User user = new User();
        //user.setId(18);
    }
}

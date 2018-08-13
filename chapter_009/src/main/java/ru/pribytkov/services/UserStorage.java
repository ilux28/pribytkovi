package ru.pribytkov.services;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.User;


public class UserStorage {
    SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();
    Session session = factory.openSession();
    Transaction transaction = session.beginTransaction();
    User user = new User();
    user.setId();

}

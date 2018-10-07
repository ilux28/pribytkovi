package ru.pribytkov.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.Item;

public class HibernateManager {
    private static HibernateManager instance;
    private static SessionFactory factory;
    private HibernateManager() {

    }
    public static synchronized HibernateManager getInstance() {
        if (instance == null) {
            instance = new HibernateManager();
        }
        return instance;
    }
    public Session getSession() {
        Session session = this.factory.openSession();
        return session;
    }
    public void initFactory() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        this.factory = factory;
    }
    public SessionFactory getFactory() {
        return this.factory;
    }
    public void closeFactory() {
        this.factory.close();
    }
}

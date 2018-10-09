package ru.pribytkov.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.Item;

public class HibernateManager {
    private static final HibernateManager INSTANCE = new HibernateManager();
    private static SessionFactory factory;
    private HibernateManager() {
        getFactory();
    }
    public static synchronized HibernateManager getInstance() {
        return INSTANCE;
    }
    public Session getSession() {
        Session session = this.factory.openSession();
        return session;
    }
    public SessionFactory getFactory() {
        if (this.factory == null) {
            this.factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return this.factory;
    }
    public void closeFactory() {
        this.factory.close();
    }
}
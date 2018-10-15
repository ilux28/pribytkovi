package ru.pribytkov.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.Item;
public class HibernateManager {
    private static SessionFactory factory;
    private static final HibernateManager INSTANCE = new HibernateManager();
    private HibernateManager() {
        openFactory();
    }
    public static HibernateManager getInstance() {
        return INSTANCE;
    }
    public void closeFactory() {
        factory.close();
    }
    private void openFactory() {
        factory = new Configuration().configure().buildSessionFactory();
    }
    public SessionFactory getFactory() {
        return factory;
    }
    public Session getSession() {
        return factory.openSession();
    }
}
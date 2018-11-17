package ru.pribytkov.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.Item;

import java.util.function.Function;

public class HibernateManager {
    private static SessionFactory factory;
    private static final HibernateManager INSTANCE = new HibernateManager();
    private HibernateManager() {
        openFactory();
    }
    public <T> T tr(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tr = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (Exception e) {
            tr.rollback();
            throw e;
        } finally {
            tr.commit();
            session.close();
        }
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
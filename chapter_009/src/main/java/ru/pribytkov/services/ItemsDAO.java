package ru.pribytkov.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.Item;

public class ItemsDAO {
    private static final HibernateManager FACTORY = HibernateManager.getInstance();

    public void addItem(String desc, boolean created, boolean done) {
        Session session = FACTORY.getSession();
        Transaction tr = session.beginTransaction();
        Item item = new Item();
        item.setDesc(desc);
        item.setCreated(created);
        item.setDone(done);
        try {
            session.save(item);
            System.out.println("Transaction was committed succeful");
        } catch (HibernateException e) {
            tr.rollback();
            System.out.println("Error! Transaction was committed with rollback");
        } finally {
            tr.commit();
            session.close();
        }

    }
}

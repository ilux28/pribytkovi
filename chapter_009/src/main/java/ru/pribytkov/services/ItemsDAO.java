package ru.pribytkov.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.Item;
//import java.util.ArrayList;
import java.util.List;

public class ItemsDAO {
    public void addItem(String desc, boolean created, boolean done) throws Exception, HibernateException {
        Session session = HibernateManager.getInstance().getSession();
        Transaction tr = session.beginTransaction();
        List items;
        Item item = new Item();
        item.setDesc(desc);
        item.setCreated(created);
        item.setDone(done);
        try {
            session.save(item);
            System.out.println();
        } catch (HibernateException e) {
            tr.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            tr.commit();
            session.close();
        }
    }
    public void deleteItem(int itemId) throws Exception, HibernateException {
        Session session = HibernateManager.getInstance().getSession();
        Transaction tr = session.beginTransaction();
        List items;
        Item item = new Item();
        item.setId(itemId);
        //items = session.createQuery("from Item").list();
        try {
            session.delete(item);
        } catch (HibernateException e) {
            tr.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            tr.commit();
            session.close();
        }
    }
}

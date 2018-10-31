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
        //items = session.createQuery("from Item").list();
        //System.out.println(items);
        //desc = "This is " + items.size() + 1  + " description of test";
        Transaction tr = session.beginTransaction();
        List items;
        Item item = new Item();
        items = session.createQuery("from Item").list();
        desc = desc + " " + items.size();
        item.setDesc(desc);
        item.setCreated(created);
        item.setDone(done);
        try {
            session.save(item);
            items = session.createQuery("from Item").list();
            System.out.println(items);
        } catch (HibernateException e) {
            tr.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            tr.commit();
            session.close();
        }
    }
    public void deleteItem(int num) throws Exception, HibernateException {
        Session session = HibernateManager.getInstance().getSession();
        Transaction tr = session.beginTransaction();
        List items;
        Item item = new Item();
        items = session.createQuery("from Item").list();
        try {
            session.save(item);
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

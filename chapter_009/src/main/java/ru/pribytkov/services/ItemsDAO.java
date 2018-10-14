package ru.pribytkov.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemsDAO {
    public void addItem(String desc, boolean created, boolean done) {
        Session session = HibernateManager.getInstance().getSession();
        Transaction tr = session.beginTransaction();
        List<Item> items = new ArrayList<Item>();
        Item item = new Item();
        items = session.createQuery("from Item").list();
        desc = desc + " " + items.size();
        item.setDesc(desc);
        item.setCreated(created);
        item.setDone(done);
        try {
            session.save(item);
            System.out.println("Transaction was committed succeful");
        } catch (HibernateException e) {
            tr.rollback();
            throw e;
        } finally {
            tr.commit();
            session.close();
            HibernateManager.getInstance().closeFactory();
            items = session.createQuery("from Item").list();
            System.out.println(items);
        }
    }
}

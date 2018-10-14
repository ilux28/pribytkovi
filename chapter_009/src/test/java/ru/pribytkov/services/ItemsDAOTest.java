package ru.pribytkov.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import ru.pribytkov.models.Item;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ItemsDAOTest {
    @Test
    public void addItemDAO() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession(); //с ним работает

        //Session session = HibernateManager.getInstance().getSession();
        Transaction tr = session.beginTransaction();
        List<Item> items = new ArrayList<Item>();
        Item item = new Item();
        items = session.createQuery("from Item").list();
        String desc = "This is " +items.size() + " description of test";
        boolean created = true;
        boolean done = true;
        item.setDesc(desc);
        item.setCreated(created);
        item.setDone(done);
        session.save(item);
        System.out.println(items);
        tr.commit();
        session.close();
        factory.close();
        //HibernateManager.getInstance().closeFactory();
    }
}
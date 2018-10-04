package ru.pribytkov.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.models.Item;

public class ItemsStorage {
    SessionFactory factory = new Configuration()
            .configure() // configures settings from hibernate.cfg.xml
            .buildSessionFactory();
    Session session = factory.openSession();
    public void addItem(String desc, boolean created, boolean done) {
        session.beginTransaction();
        Item item = new Item();
        item.setDesc(desc);
        item.setCreated(created);
        item.setDone(done);
    }
}

package ru.pribytkov.servlets;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.services.HibernateManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class ControllerContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent servletContextEvent) {
      HibernateManager.getInstance().getFactory();
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
       HibernateManager.getInstance().closeFactory();
    }
}

package ru.pribytkov.servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.services.HibernateManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class ControllerContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        SessionFactory factory = HibernateManager.getInstance().getFactory();
        context.setAttribute("factory", factory);
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
       HibernateManager.getInstance().closeFactory();
    }
}

package ru.pribytkov.servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pribytkov.services.HibernateManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class ControllerContextListener implements ServletContextListener {
    //private SessionFactory factory;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
      /*  ServletContext context = servletContextEvent.getServletContext();
        this.factory = new Configuration().configure().buildSessionFactory();
        context.setAttribute("factory", this.factory);
        //HibernateManager.getInstance();
        */
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        /*
        this.factory.close();
       //HibernateManager.getInstance().closeFactory();
       */
    }

}

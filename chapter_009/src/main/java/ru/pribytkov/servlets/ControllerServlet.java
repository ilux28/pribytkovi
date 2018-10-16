package ru.pribytkov.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.pribytkov.services.HibernateManager;
import ru.pribytkov.services.ItemsDAO;
import ru.pribytkov.util.Converter;
import ru.pribytkov.models.Item;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ControllerServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String desc = request.getParameter("description");
        String create = request.getParameter("created");
        String don = request.getParameter("done");
        boolean created = Boolean.parseBoolean(create);
        boolean done = Boolean.parseBoolean(don);
        List items = new ArrayList<Item>();
        Session session = HibernateManager.getInstance().getSession();
        items = session.createQuery("from Item").list();
        System.out.println(items);
        desc = "This is " + items.size() + 1  + " description of test";
        ItemsDAO itemDao = new ItemsDAO();
        try {
            itemDao.addItem(session, desc, created, done);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //request.getRequestDispatcher("/WEB-INF/index.html").forward(request, response);
        response.sendRedirect(String.format("%s/", request.getContextPath()));
        System.out.println("pizda");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        Session session = HibernateManager.getInstance().getSession();
        Map<String, Item> map = new HashMap<String, Item>();
        List<Item> items = new ArrayList<Item>();
        items = session.createQuery("from Item").list();
        for (Item item : items) {
            String str = Integer.toString((int)item.getId());
            map.put(str, item);
        }
        session.close();
        //Converter converter = new Converter();
        String sendJson = new ObjectMapper().writeValueAsString(map);
                // converter.toJSON(itemFirst);
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append(sendJson);
        writer.flush();
    }
}

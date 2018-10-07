package ru.pribytkov.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.pribytkov.services.ItemsDAO;
import ru.pribytkov.util.Converter;
import ru.pribytkov.models.Item;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ControllerServlet.class);
    /*private JSONObject resultJson = new JSONObject();
    public JSONObject getResultJson() {
        return resultJson;
    }
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String description = request.getParameter("description");
        String create = request.getParameter("created");
        String don = request.getParameter("done");
        boolean created = Boolean.parseBoolean(create);
        boolean done = Boolean.parseBoolean(don);
        //ItemsDAO example = new ItemsDAO();
        //example.addItem(description, created, done);
        System.out.println(id);
        System.out.println(description);
        System.out.println(created);
        System.out.println(done);
        /*try {
            ItemsDAO example = new ItemsDAO();
            example.addItem(description, created, done);
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
        } finally {
            System.out.println(id);
            System.out.println(description);
            System.out.println(created);
            System.out.println(done);
        }
        */
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        Item itemFirst = new Item(1, "Description of first iitem", true, true);
        Item itemSecond = new Item(2, "Description of second iitem", true, false);
        Map<String, Item> map = new HashMap<String, Item>();
        String ifId = Integer.toString((int) itemFirst.getId());
        String isId = Integer.toString((int) itemSecond.getId());
        map.put(ifId, itemFirst);
        map.put(isId, itemSecond);
        Converter converter = new Converter();
        String sendJson = new ObjectMapper().writeValueAsString(map);
                // converter.toJSON(itemFirst);
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append(sendJson);
        writer.flush();
    }
}

package ru.pribytkov.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    /*private JSONObject resultJson = new JSONObject();

    public JSONObject getResultJson() {
        return resultJson;
    }
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String created = request.getParameter("created");
        String done = request.getParameter("done");
        System.out.println(description);
        System.out.println(created);
        System.out.println(done);
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

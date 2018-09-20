package ru.pribytkov.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {

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
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append("[{'description':'description about first item','created':'true', 'done':'true'}]");
        writer.flush();
    }
}

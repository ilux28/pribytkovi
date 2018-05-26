package pribytkovi.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EchoServlet extends HttpServlet {
    private static  final Logger Log = LoggerFactory.getLogger(EchoServlet.class);
    private List<User> users = new CopyOnWriteArrayList<User>();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
        res.setContentType("text/html");
        //String login = req.getParameter("login");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        //for (String log : users) {
            writer.append("hello world " + this.users);
        //}
        writer.flush();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        String login = req.getParameter("action");
        this.users.add(new User(login));
        doGet(req, res);
    }
}

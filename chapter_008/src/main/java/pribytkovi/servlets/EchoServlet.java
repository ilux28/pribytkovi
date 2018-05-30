package pribytkovi.servlets;

import com.sun.jmx.snmp.Timestamp;
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
        System.out.println("Enter doGet");

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
        String action = req.getParameter("action");
        String id = req.getParameter("id");
        int yd = Integer.parseInt(id);
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Timestamp date = new Timestamp();
        //req.setAttribute("UserList", this.users);
        switch (action == null ? "info" : action) {
            case "add":
                User user = new User(yd, name, email);
                this.users.add(user);
                break;
            case "update" :
                for (int i = 0; i < users.size(); i++)
                if (users.get(i).getId() == yd) {
                    User use = users.get(i);
                    use.setName(name);
                    use.setEmail(email);
                }
                break;
            case "delete" :
                for (int i = 0; i < users.size(); i++)
                    if (users.get(i).getId() == yd) {
                        users.remove(users.get(i));
                    }
                break;
        }
        //if ()
        //this.users.add(new User());
        doGet(req, res);
    }
}

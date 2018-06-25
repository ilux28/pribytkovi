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

public class UsersController extends HttpServlet {
    private static  final Logger Log = LoggerFactory.getLogger(UsersController.class);
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
       req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        String action = req.getParameter("action");
        String id = req.getParameter("id");
        int yd = Integer.parseInt(id);
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Timestamp date = new Timestamp();
        List<User> users = UserStorage.getInstance().getUsers();
        //req.setAttribute("UserList", this.users);
        switch (action == null ? "info" : action) {
            case "add":
                User user = new User(yd, name, email);
                UserStorage.getInstance().add(user);
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
        res.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
        //doGet(req, res);
    }
}

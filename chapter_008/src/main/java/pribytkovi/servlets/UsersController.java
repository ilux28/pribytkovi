package pribytkovi.servlets;

import com.sun.jmx.snmp.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersController extends HttpServlet {
    private static  final Logger Log = LoggerFactory.getLogger(UsersController.class);
    private List<User> users = new CopyOnWriteArrayList<>();
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
       System.out.println("Method doPost UserController");
       HttpSession session = req.getSession(false);
           System.out.println("Method doPost UserController_2");
           req.setAttribute("users", UserStorage.getInstance().getUsers());
           req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, res);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       res.setContentType("text/html");
       //UserStorage.getInstance().add(new User(1, req.getParameter("name"), req.getParameter("email"), req.getParameter("password")));
       //res.sendRedirect(String.format("%s/", req.getContextPath()));
       System.out.println("Method doPost UserController");
       //doGet(req, res);
       String action = req.getParameter("action");
       String id = req.getParameter("id");
       int yd = Integer.parseInt(id);
       String name = req.getParameter("name");
       String email = req.getParameter("email");
       String password = req.getParameter("password");
       Timestamp date = new Timestamp();

        //req.setAttribute("UserList", this.users);
        switch (action == null ? "info" : action) {
            case "add":
                System.out.println("Method doPost UserController add");
                User user = new User(yd, name, email, password);
                UserStorage.getInstance().add(user);
                break;
            case "update" :
                System.out.println("Method doPost UserController update");
                for (int i = 0; i < UserStorage.getInstance().getUsers().size(); i++)
                    if (UserStorage.getInstance().getUsers().get(i).getId() == yd) {
                        users.get(i).setName(name);
                        users.get(i).setEmail(email);
                }
                break;
            case "delete" :
                System.out.println("Method doPost UserController delete");
                for (int i = 0; i < UserStorage.getInstance().getUsers().size(); i++)
                    if (UserStorage.getInstance().getUsers().get(i).getId() == yd) {
                        UserStorage.getInstance().getUsers().remove(UserStorage.getInstance().getUsers().get(i));
                    }
                break;
        }
        //System.out.println("doGet UserController");
        doGet(req, res);
    }
}

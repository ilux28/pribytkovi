package pribytkovi.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SigninController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession(false);
       synchronized (session) {
           if (session == null || session.getAttribute("name") == null) {
               response.sendRedirect(String.format("%s/signin", request.getContextPath()));
           }
       }
        request.setAttribute("users", UserStorage.getInstance().getUsers());
        request.getRequestDispatcher("/WEB-INF/view/LoginView.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (UserStorage.getInstance().isCredentional(name, password)) {
            HttpSession session = request.getSession();
            synchronized (session) {
                session.setAttribute("name", name);
            }
            response.sendRedirect(String.format("%s/", request.getContextPath()));

        } else {
            request.setAttribute("error", "Credentional invalid");
            doGet(request, response);
        }
    }
}

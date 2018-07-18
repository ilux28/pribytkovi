package pribytkovi.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SigninController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(request, response);
       System.out.println("Signin_1");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (UserStorage.getInstance().isCredentional(name, password)) {
            HttpSession session = request.getSession();
            System.out.println("Signin_2");
            synchronized (session) {
                session.setAttribute("name", name);
            }
            response.sendRedirect(String.format("%s/UsersView.jsp", request.getContextPath()));
        } else {
            request.setAttribute("error", "Credentional invalid");
            System.out.println("Signin_3");
            //doGet(request, response);
            request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(request, response);
        }
    }
}
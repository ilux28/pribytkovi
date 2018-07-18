package pribytkovi.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.directory.InvalidSearchFilterException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.Filter;
import java.util.logging.LogRecord;

public class AuthFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);


    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String uri = (String) request.getRequestURI();
        String[] muri = uri.split("/");
        System.out.println(uri);
        for (String u : muri)
            System.out.println(u);
        if (uri.equals("/signin") || uri.equals("/userlog")) {
            System.out.println("1");
            chain.doFilter(request, response);
        } else if (uri.contains(".jsp")) {
            request.getRequestDispatcher("/WEB-INF/views/" + muri[muri.length - 1]).forward(request, response);
            return;
        } else {
            request.getRequestDispatcher("/WEB-INF/views/MainView.jsp").forward(request, response);
            return;
        }
    }
}
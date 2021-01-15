package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/c")
public class MyCookie extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 3421020204357384115L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c = new Cookie("myCookie", "ok");
        c.setMaxAge(60*60); 
        c.setPath("/");
        resp.addCookie(c);
        
        getServletContext().getRequestDispatcher("/cookie.jsp").forward(req, resp);

        
    }
}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "test", urlPatterns = "/throw")
public class ThrowCookie extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -5470489432210173088L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            resp.addCookie(cookie);
        }
        req.setAttribute("cookie", "fakeCookie");
        getServletContext().getRequestDispatcher("/throwCookie.jsp").forward(req, resp);
    }
}

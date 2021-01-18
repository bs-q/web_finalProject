/*
 * File Created: Monday, 18th January 2021 9:48:17 am
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.util.CookieUtil;

@WebServlet(urlPatterns = {"/logout"})
public class LogOutServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 5444368759601420248L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.removeAttribute("email");
        CookieUtil.removeAllCookie(req.getCookies(), resp);
        getServletContext().getRequestDispatcher("/home").forward(req, resp);
    }
}

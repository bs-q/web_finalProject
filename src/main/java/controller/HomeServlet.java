/*
 * File Created: Saturday, 16th January 2021 6:58:23 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.shoesDao.ShoesDAO;
import data.util.CookieUtil;
import models.Shoes;

@WebServlet(urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = -4141802996948221652L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("allShoes") != null) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        String cookieEmail=CookieUtil.getCookieValue(req.getCookies(), "email");
        if (cookieEmail!=null){
            session.setAttribute("email", cookieEmail);
            List<Shoes> allShoes = ShoesDAO.retrieveAllShoes();
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        } 
        else {
            List<Shoes> allShoes = ShoesDAO.retrieveAllShoes();
            session.setAttribute("allShoes", allShoes);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

}

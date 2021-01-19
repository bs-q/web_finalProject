/*
 * File Created: Monday, 18th January 2021 11:10:25 pm Author: Bui Si Quan
 * (18110041@student.hcmute.edu.vn) -----
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

import data.cartDao.CartDao;
import data.util.CookieUtil;
import models.CartItems;

/**
 * This servlet control cart
 */
@WebServlet(urlPatterns = { "/cart" })
public class CartServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -2117144651004442878L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null) {
            String cookieEmail = CookieUtil.getCookieValue(req.getCookies(), "email");
            if (cookieEmail != "") {
                session.setAttribute("email", "");
            } else {
                getServletContext().getRequestDispatcher("/login").forward(req, resp);
            }
        }
        try {

            List<CartItems> items = CartDao.retrieveAllItemInCart("q@gmail.com", false);
            req.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/shopping-cart.jsp").forward(req, resp);
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/testlogin.jsp").forward(req, resp);
        }
    }
}

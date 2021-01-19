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
import models.Cart;
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
        // check session
        if (session.getAttribute("email") == null) {
            // check cookie, then assign it to session
            if (req.getCookies() == null) {
                getServletContext().getRequestDispatcher("/login").forward(req, resp);
                System.out.println("cart servlet : line 42 - null cookie");
                return;
            }
            // get cookie value
            String cookieEmail = CookieUtil.getCookieValue(req.getCookies(), "email");
            if (cookieEmail != "") {
                // assign to session
                session.setAttribute("email", cookieEmail);
            } else {
                // this is the case when customer just logout or cookie has expired
                getServletContext().getRequestDispatcher("/login").forward(req, resp);
                System.out.println("cart servlet : line -53 failed to get cookie");
                return;
            }
        }
        try {
            // get cart which is not checked out

            Cart c = CartDao.selectCartByEmailAndStatus((String) session.getAttribute("email"), false);
            if (c == null) {
                getServletContext().getRequestDispatcher("/cart.jsp").forward(req, resp);
                System.out.println("cart servlet : line 63 - no cart found, is it ok to forward to cart?");
                return;
            }
            // get items in cart
            List<CartItems> items = c.getCartItems();
            // assign it to request
            req.setAttribute("items", items);
            // get cart id, this is a signal to remove item
            req.setAttribute("cartId", c.getCartId());
            System.out.println("cart servlet: line 72 - request cart id (a signal to remove item):" + c.getCartId());

            getServletContext().getRequestDispatcher("/cart.jsp").forward(req, resp);
            System.out.println("cart servlet : line 75 - ok, cart servlet working normally");
            return;
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/login").forward(req, resp);
            System.out.println("cart servlet : line 79 - failed to get items, login first");
            return;
        }
    }
}

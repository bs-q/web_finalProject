/*
 * File Created: Tuesday, 19th January 2021 9:41:22 pm
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

import data.cartDao.CartDao;
import data.util.CookieUtil;
import models.Cart;
import models.CartItems;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckOutServlet extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 9190395150103646533L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // check session
        if (session.getAttribute("email") == null) {
            // check cookie, then assign it to session
            if (req.getCookies() == null) {
                getServletContext().getRequestDispatcher("/login").forward(req, resp);
                System.out.println("checkout servlet : line 34 - null cookie");
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
                System.out.println("checkout servlet : line - 46 failed to get cookie");
                return;
            }
        }
        // begin checkout
        Cart cart =CartDao.selectCartByEmailAndStatus((String) session.getAttribute("email"), false);
        if(cart ==null){
            getServletContext().getRequestDispatcher("/product").forward(req, resp);
            System.out.println("check out servlet : line 56 - no items in cart, forward to product page");
            return; 
        }
        req.setAttribute("cartid", cart.getCartId());
        System.out.println("check out servlet: line 61 - cart id :"+cart.getCartId());
        req.setAttribute("items", cart.getCartItems());
        getServletContext().getRequestDispatcher("/checkOut.jsp").forward(req, resp);
        System.out.println("check out servlet : line 63 - forward to checkout page");
    }
}

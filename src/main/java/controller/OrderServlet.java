/*
 * File Created: Tuesday, 19th January 2021 10:15:44 pm Author: Bui Si Quan
 * (18110041@student.hcmute.edu.vn) -----
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.cartDao.CartDao;
import models.Cart;

@WebServlet(urlPatterns = { "/order" })
public class OrderServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 2515820736820398077L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("phone"));
        System.out.println(req.getParameter("fname"));
        System.out.println(req.getParameter("lname"));
        System.out.println(req.getParameter("address"));
        System.out.println(req.getParameter("apartment"));
        System.out.println(req.getParameter("total"));
        System.out.println(req.getParameter("cid"));
        Cart cart = CartDao.selectCartById(Integer.parseInt(req.getParameter("cid")));
        cart.setStatus(true);
        if (CartDao.updateCart(cart)) {
            getServletContext().getRequestDispatcher("/thank.html").forward(req, resp);
            System.out.println("order servlet : line 40 - order success");
        } else {
            getServletContext().getRequestDispatcher("/errorPage.html").forward(req, resp);
            System.out.println("order servlet : line 43 - order failed");

        }

    }

}

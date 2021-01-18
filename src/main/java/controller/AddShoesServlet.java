/*
 * File Created: Saturday, 16th January 2021 11:13:45 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.cartDao.CartDao;
import data.cartItemDao.CartItemsDAO;
import data.customerDAO.CustomerDAO;
import data.shoesDao.ShoesDAO;
import data.util.CookieUtil;
import data.util.DButil;
import models.Cart;
import models.CartItems;
import models.Customer;
import models.Shoes;

@WebServlet(urlPatterns = { "/add" })
public class AddShoesServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 2169014635775342898L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // if customer is not login, send error
        if (null == session.getAttribute("email")) {
            String cookieEmail = CookieUtil.getCookieValue(req.getCookies(), "email");
            if (cookieEmail.equals("")) {
                // error code 409
                resp.sendError(HttpServletResponse.SC_GONE, "login required");
                return;
            } else {
                session.setAttribute("email", cookieEmail);
            }
        }
        // check param
        if (req.getParameter("shoesId") == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "shoes id is required");
            return;

        }
        // check format
        if (!checkFormat(req.getParameter("shoesId"))) {
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "wrong shoes id format");
            return;

        }
        Shoes shoes = checkShoes(Integer.parseInt(req.getParameter("shoesId")));
        if (shoes == null) {
            resp.sendError(HttpServletResponse.SC_CONFLICT, "wrong shoes id");
            return;

        }
        // now check validity of cart
        Customer customer = CustomerDAO.selectCustomer((String) session.getAttribute("email"));

        // check if user never use cart
        if (customer.getCart().size() == 0) {
            Cart cart = new Cart();
            cart.setCustomer(customer);
            CartItems item = new CartItems();
            CartDao.insertCart(cart);
            item.setCartItemsQuantity(1);
            item.setCart(cart);
            item.setShoes(shoes);
            if (CartItemsDAO.insertCartItem(item)) {
                resp.sendError(HttpServletResponse.SC_OK, "ok");
                return;

            } else {
                resp.sendError(HttpServletResponse.SC_NO_CONTENT, "transaction failed, can not insert item");
                return;

            }
        }

        // if user has used cart before, select cart that status is false and that item
        // has never added
        List<Cart> lCarts = customer.getCart();
        for (Cart c : lCarts) {
            if (c.isStatus() == false) {
                EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
                String qString = "select u from CartItems u where u.shoes.shoesId=:id";
                TypedQuery<CartItems> q = em.createQuery(qString, CartItems.class);
                q.setParameter("id",Integer.parseInt(req.getParameter("shoesId")));
                CartItems cartItems = null;
                try {
                    cartItems = q.getSingleResult();
                } catch (NoResultException e) {
                    System.out.println(e);
                } finally {
                    em.close();
                }
                if(cartItems!=null){
                    resp.sendError(HttpServletResponse.SC_OK, "ok");
                    return;
                }
                CartItems item = new CartItems();
                item.setCart(c);
                item.setShoes(shoes);
                if (CartItemsDAO.insertCartItem(item)) {
                    resp.sendError(HttpServletResponse.SC_OK, "ok");
                    return;

                } else {
                    resp.sendError(HttpServletResponse.SC_NO_CONTENT, "transaction failed, can not insert item");
                    return;
                }
            }
        }
        resp.sendError(HttpServletResponse.SC_SEE_OTHER, "mysterious bug, im tired");
    }

    /**
     * Check valid shoes code
     * 
     * @param id
     * @return null if shoes id is not valid, or return shoes
     */
    static Shoes checkShoes(int id) {
        return ShoesDAO.selectShoesById(id);
    }

    static boolean checkFormat(String id) {
        try {
            int parse = Integer.parseInt(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

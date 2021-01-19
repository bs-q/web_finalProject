/*
 * File Created: Saturday, 16th January 2021 11:13:45 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
                System.out.println("add shoes servlet : line 54 - login required");
                resp.sendError(HttpServletResponse.SC_GONE, "login required");
                return;
            } else {
                session.setAttribute("email", cookieEmail);
            }
        }
        // check param
        if (req.getParameter("shoesId") == null) {
            System.out.println("add shoes servlet : line 63 - shoes id is required");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "shoes id is required");

            return;

        }
        // check format
        if (!checkFormat(req.getParameter("shoesId"))) {
            System.out.println("add shoes servlet : line 71 - wrong shoes id format");
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "wrong shoes id format");
            return;

        }
        Shoes shoes = checkShoes(Integer.parseInt(req.getParameter("shoesId")));
        if (shoes == null) {
            System.out.println("add shoes servlet : line 78 - wrong shoes id");
            resp.sendError(HttpServletResponse.SC_CONFLICT, "wrong shoes id");
            return;

        }
        // now check validity of cart
        Customer customer = CustomerDAO.selectCustomer((String) session.getAttribute("email"));

        // check if user never use cart
        if (customer.getCart().size() == 0) {
            Cart cart = new Cart();
            cart.setCustomer(customer);
            cart.setTime(new Date());
            CartItems item = new CartItems();
            CartDao.insertCart(cart);
            item.setCartItemsQuantity(1);
            item.setCart(cart);
            item.setShoes(shoes);
            if (CartItemsDAO.insertCartItem(item)) {
                resp.sendError(HttpServletResponse.SC_OK, "ok");
                System.out.println("add shoes servlet : line 97 - ok number 2");
                return;

            } else {
                System.out.println("add shoes servlet : line 102 - transaction failed, can not insert item 1");
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
                EntityTransaction trans = em.getTransaction();

                String qString = "select u from CartItems u where u.shoes.shoesId=:id";
                TypedQuery<CartItems> q = em.createQuery(qString, CartItems.class);
                q.setParameter("id", Integer.parseInt(req.getParameter("shoesId")));
                CartItems cartItems = null;
                try {
                    trans.begin();

                    cartItems = q.getSingleResult();
                    trans.commit();

                } catch (NoResultException e) {
                    System.out.println(e);
                    trans.rollback();
                } finally {
                    em.close();
                }
                if (cartItems != null) {
                    System.out.println("add shoes servlet : line 134 - ok 3");
                    resp.sendError(HttpServletResponse.SC_OK, "ok");
                    return;
                }
                cartItems = new CartItems();
                cartItems.setCart(c);
                cartItems.setShoes(shoes);
                cartItems.setCartItemsQuantity(1);
                if (CartItemsDAO.insertCartItem(cartItems)) {
                    System.out.println("add shoes servlet : line 143 - ok 4");
                    resp.sendError(HttpServletResponse.SC_OK, "ok");
                    return;

                } else {
                    System.out.println("add shoes servlet : line 148 - transaction failed, can not insert item 2");
                    resp.sendError(HttpServletResponse.SC_NO_CONTENT, "transaction failed, can not insert item");
                    return;
                }
            }
        }
        // if all cart has check out, create new cart
        Cart cart = new Cart();
        cart.setCustomer(customer);
        CartItems item = new CartItems();
        if (!CartDao.insertCart(cart)) {
            System.out.println("add shoes servlet : line 159 - transaction failed, can not insert item 3");
            resp.sendError(HttpServletResponse.SC_NO_CONTENT, "transaction failed, can not insert item");

            return;
        }
        item.setCartItemsQuantity(1);
        item.setCart(cart);
        item.setShoes(shoes);
        if (CartItemsDAO.insertCartItem(item)) {
            System.out.println("add shoes servlet : line 168 - ok 5");
            resp.sendError(HttpServletResponse.SC_OK, "ok");

            return;

        } else {
            System.out.println("add shoes servlet : line 173 - transaction failed, can not insert item 4");
            resp.sendError(HttpServletResponse.SC_NO_CONTENT, "transaction failed, can not insert item");

            return;
        }

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
            Integer.parseInt(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

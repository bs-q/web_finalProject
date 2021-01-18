package data.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import data.cartDao.CartDao;
import data.cartItemDao.CartItemsDAO;
import data.customerDAO.CustomerDAO;
import models.Cart;
import models.CartItems;
import models.Color;
import models.Customer;
import models.Shoes;

public class DBconnection {

    public static void main(String[] args) throws InterruptedException {
        EntityManager em =DButil.getEntityManagerFactory().createEntityManager();
        String qString = "select u from CartItems u where u.shoes.shoesId=101";
        TypedQuery<CartItems> q = em.createQuery(qString, CartItems.class);
    
        CartItems cartItems = null;
        try {
            cartItems = q.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        // MailServlet.send("18110041@student.hcmute.edu.vn", "accounts.google.com",
        // "18110007@student.hcmute.edu.vn", "hello", "How r u?");
        // DButil.shutdown();

    }

}

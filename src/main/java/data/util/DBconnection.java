package data.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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

        List<String>a=null;
        for(String c:a){

        }
        // System.out.println(CartDao.retrieveAllItemInCart("q@gmail.com",
        // false).get(0).getCartItemsQuantity());
        // MailServlet.send("18110041@student.hcmute.edu.vn", "accounts.google.com",
        // "18110055@student.hcmute.edu.vn", "hello", "How r u?");
        // // DButil.shutdown();

    }

}

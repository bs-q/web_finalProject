package data.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import data.cartDao.CartDao;
import data.customerDAO.CustomerDAO;
import models.Cart;
import models.CartItems;
import models.Color;
import models.Customer;
import models.Shoes;

public class DBconnection {

    public static void main(String[] args) throws InterruptedException {

        Pattern firstNamePattern = Pattern.compile("^[\\w.+\\-]+@gmail\\.com$");
        Matcher firstNameMatch = firstNamePattern.matcher("a@gmail.com");
        if (firstNameMatch.matches())
        {
            System.out.println("ok");
        }
        else {
            System.out.println(":(");
        }
        // MailServlet.send("18110041@student.hcmute.edu.vn", "accounts.google.com",
        // "18110007@student.hcmute.edu.vn", "hello cunt", "How r u?");
        // DButil.shutdown();

    }

}

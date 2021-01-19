/*
 * File Created: Friday, 15th January 2021 6:28:02 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 * Last Modified: Friday, 15th January 2021 6:28:02 pm
 */
package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.customerDAO.CustomerDAO;
import data.util.Encrypt;
import models.Customer;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 4249780684684026453L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String conPassword = req.getParameter("password-cf");
        if (!validateInput(firstName, lastName, email, password, conPassword)) {
            req.setAttribute("firstname", firstName);
            req.setAttribute("lastname", lastName);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("conPassword", conPassword);
            getServletContext().getRequestDispatcher("/signup.jsp").forward(req, resp);
            System.out.println("register servlet : line 46 - invalid input");
        }
        else if (CustomerDAO.emailExist(email)){
            req.setAttribute("firstname", firstName);
            req.setAttribute("lastname", lastName);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("conPassword", conPassword);
            req.setAttribute("registered", true);
            getServletContext().getRequestDispatcher("/signup.jsp").forward(req, resp);
            System.out.println("register servlet : line 56 - email has been registered");
        }
        else {
            Customer customer = new Customer(firstName, lastName, email, Encrypt.sha1(password), "", "customer", "");
            CustomerDAO.insertCustomer(customer);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            System.out.println("register servlet : line 62 - successfully create new account");
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/signup.jsp").forward(req, resp);
        System.out.println("regiser servlet : line 69 - get register");
    }

    /**
     * Check validity of customer input
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param conPassword confirm password
     * @return true if customer input is valid, else false
     */
    static boolean validateInput(String firstName, String lastName, String email, String password, String conPassword) {
        Pattern firstNamePattern = Pattern.compile("^[a-zA-Z\\s]+");
        Matcher firstNameMatch = firstNamePattern.matcher(firstName);
        Pattern lastNamePattern = Pattern.compile("^[a-zA-Z\\s]+");
        Matcher lastNameMatch = lastNamePattern.matcher(lastName);
        Pattern emailPattern = Pattern.compile("^[\\w.+\\-]+@gmail\\.com$");
        Matcher emailMatch = emailPattern.matcher(email);
        Pattern passwordPattern = Pattern.compile("^\\S{6,}$");
        Matcher passwordMatch = passwordPattern.matcher(password);
        Pattern conPasswordPattern = Pattern.compile("^\\S{6,}$");
        Matcher conPasswordMatch = conPasswordPattern.matcher(password);
        if (firstNameMatch.matches() && lastNameMatch.matches() && emailMatch.matches() && passwordMatch.matches()
                && conPasswordMatch.matches() && (password.equals(conPassword))) {
            return true;
        } else {
            return false;
        }
    }
}

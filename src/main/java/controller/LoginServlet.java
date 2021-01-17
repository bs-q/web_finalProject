/*
 * File Created: Friday, 15th January 2021 11:24:26 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 * Last Modified: Friday, 15th January 2021 11:24:27 pm
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.customerDAO.CustomerDAO;
import data.util.Encrypt;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 4249780684684026453L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        // get request from customer, check its validity and then assign access right to
        // customer
        if (valid(email, password)) {
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("valid", false);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            Cookie emailCookie=new Cookie("email", email);
            //set cookie age to 1 hour
            emailCookie.setMaxAge(60*60);
            // allow access by entire app
            emailCookie.setPath("/");
            // add cookie to response
            resp.addCookie(emailCookie);
            Cookie passwordCooke=new Cookie("key",Encrypt.sha1(password));
            // send redirect, a alternative way to preserve clean url
            // set cookie age to 1 hour
            passwordCooke.setMaxAge(60 * 60);
            // allow access by entire app
            passwordCooke.setPath("/");
            // add cookie to response
            resp.addCookie(passwordCooke);

            resp.sendRedirect("home");
            // getServletContext().getRequestDispatcher("/home").forward(req, resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // if email and password in session is empty that mean user have closed browser
        // or haven't login, forward to login.jsp else forward to home, maybe use cookie to do this job
        if (session.getAttribute("email") == null) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/home").forward(req, resp);
        }

    }

    /**
     * Check if customer input is valid and customer provide correct email and
     * password
     * 
     * @param email
     * @param password
     * @return true if information is valid else false
     */
    static Boolean valid(String email, String password) {

        if (email.equals(null) || password.equals(null)) {
            return false;
        }
        if (CustomerDAO.validCustomer(email, Encrypt.sha1(password))) {
            return false;
        }
        return true;
    }

}

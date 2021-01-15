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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.customerDAO.CustomerDAO;

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
        if(valid(email, password)){
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("valid", false);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        else{
            getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
        }

    }

    static Boolean valid(String email, String password) {

        if (email.equals(null) || password.equals(null)) {
            return false;
        }
        if (CustomerDAO.validCustomer(email, password)) {
            return false;
        }
        return true;
    }

}

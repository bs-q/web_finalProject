/*
 * File Created: Friday, 15th January 2021 6:28:02 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 * Last Modified: Friday, 15th January 2021 6:28:02 pm
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 4249780684684026453L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String customerFirstName=req.getParameter("firstname");
        String customerLastName=req.getParameter("lastname");
        String customerEmail=req.getParameter("email");
        String customerPassword= req.getParameter("password");

        req.setAttribute("firstname", customerFirstName);
        req.setAttribute("lastname", customerLastName);
        req.setAttribute("email", customerEmail);
        req.setAttribute("password", customerPassword);

        getServletContext().getRequestDispatcher("/signup.jsp").forward(req, resp);

    }
}

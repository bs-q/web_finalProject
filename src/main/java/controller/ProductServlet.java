/*
 * File Created: Tuesday, 19th January 2021 9:30:03 pm Author: Bui Si Quan
 * (18110041@student.hcmute.edu.vn) -----
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = -4254735415528307784L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
        System.out.println("product servlet: line 25 - forward success");
    }
}

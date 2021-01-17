/*
 * File Created: Saturday, 16th January 2021 9:27:40 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/js"})
public class JavaScriptServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 8926123945164802064L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String output=req.getParameter("shoesId");
        System.out.println(output);
        resp.setStatus(200);
    }
}

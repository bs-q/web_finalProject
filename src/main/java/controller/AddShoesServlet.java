/*
 * File Created: Saturday, 16th January 2021 11:13:45 pm
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
import javax.servlet.http.HttpSession;

import data.util.CookieUtil;

@WebServlet(urlPatterns = { "/add" })
public class AddShoesServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 2169014635775342898L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null) {

            String cookieEmail = CookieUtil.getCookieValue(req.getCookies(), "email");
            String key = CookieUtil.getCookieValue(req.getCookies(), "key");
            if(key==""||cookieEmail==""){
                // error code 409
                resp.sendError(HttpServletResponse.SC_CONFLICT, "customer is not login yet");
            }
        }
    }

}

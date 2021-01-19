/*
 * File Created: Tuesday, 19th January 2021 12:32:28 pm
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

import data.cartDao.CartDao;
import data.util.CookieUtil;

@WebServlet(urlPatterns = { "/delete" })
public class DeleteShoesServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = -6614764719905605390L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        // check session
        if (session.getAttribute("email") == null) {
            // check cookie, then assign it to session
            if (req.getCookies() == null) {
                getServletContext().getRequestDispatcher("/login").forward(req, resp);
                return;
            }
            // get cookie value
            String cookieEmail = CookieUtil.getCookieValue(req.getCookies(), "email");
            if (cookieEmail != "") {
                // assign to session
                session.setAttribute("email", cookieEmail);
            } else {
                // this is the case when customer just logout or cookie has expired
                getServletContext().getRequestDispatcher("/login").forward(req, resp);
                System.out.println("delete servlet: line 46 - invalid customer");
                return;
            }
        }
        // debug mod
        int cid = 0;
        int id = 0;
        try {
            cid = Integer.parseInt(req.getParameter("cid"));
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "wrong id");
            System.out.println("delete servlet : line 58-wrong id");
            return;
        }
        boolean ok;
        try {
            ok =CartDao.deleteItemInCart((String)session.getAttribute("email"), false, id, cid);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_NO_CONTENT, "transaction failed");
            System.out.println("delete servlet : line 66: transaction failed");
            return;
        }
        System.out.println("delete servlet : line 69 - transaction complete");
        resp.sendRedirect("/cart");
    }
}

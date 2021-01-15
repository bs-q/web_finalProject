package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/pt","/pt1"} )
public class route extends HttpServlet {
    
    /**
     *
     */
    private static final long serialVersionUID = -8555070734013517405L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url="/disp.jsp";
        String greet="fuck you";
        req.setAttribute("greet", greet);
        getServletContext().getRequestDispatcher(url).forward(req, resp);;
    }

}

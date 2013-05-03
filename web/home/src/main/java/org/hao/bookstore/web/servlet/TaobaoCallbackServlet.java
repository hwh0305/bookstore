package org.hao.bookstore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaobaoCallbackServlet extends HttpServlet {

    private static final long serialVersionUID = -7258758710665434184L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionKey = req.getParameter("top_session");
        PrintWriter out = resp.getWriter();
        out.print(sessionKey);
        out.flush();
        out.close();
    }

}

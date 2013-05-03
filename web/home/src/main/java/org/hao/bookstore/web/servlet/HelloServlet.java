package org.hao.bookstore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = -2014459760881351561L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><body><h1>Hello, World!</h1></body></html>");
        out.flush();
        out.close();
    }
    
    public static void main(String[] args) {
        
        String regex = "com\\.alibaba.intl\\.biz\\.market\\.business\\.service\\.(.+)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("com.alibaba.intl.biz.market.business.service.goods.impl.MarketGoodsServiceImpl");
        System.out.println(m.matches());
    }
}

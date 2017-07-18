package com.team.hk.configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lidongliang on 2017/6/28.
 * Servlet
 * 替代xml形式
 */
@WebServlet(name = "IndexServlet", urlPatterns = "/myServlet")
public class IndexServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("hello word");
//        System.out.println("123123" + req.getContextPath());
//        resp.sendRedirect(req.getContextPath() + "/order");
//        resp.getWriter().flush();
//        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}

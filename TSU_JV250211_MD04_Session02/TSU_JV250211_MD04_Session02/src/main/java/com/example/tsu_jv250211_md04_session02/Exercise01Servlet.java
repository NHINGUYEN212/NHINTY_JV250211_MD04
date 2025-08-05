package com.example.tsu_jv250211_md04_session02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "exercise01Servlet", value = "/exercise01")
public class Exercise01Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/exercise01.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
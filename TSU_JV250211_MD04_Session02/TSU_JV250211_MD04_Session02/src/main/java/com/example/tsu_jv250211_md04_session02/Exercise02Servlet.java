package com.example.tsu_jv250211_md04_session02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "exercise02Servlet", value = "/exercise02")
public class Exercise02Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        request.setAttribute("age", 15);
        request.getRequestDispatcher("/exercise02.jsp").forward(request, response);
    }
}
package com.example.tsu_jv250211_md04_session01_bai04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "exercise04Servlet", value = "/exercise04")
public class Exercise04Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("exercise04.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usdString = request.getParameter("usd");
        String usdRate = request.getParameter("rate");

        double usd = Double.parseDouble(usdString);
        double rate = Double.parseDouble(usdRate);
        double vnd = usd * rate;

        request.setAttribute("usd", usd);
        request.setAttribute("rate", rate);
        request.setAttribute("vnd", vnd);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

}
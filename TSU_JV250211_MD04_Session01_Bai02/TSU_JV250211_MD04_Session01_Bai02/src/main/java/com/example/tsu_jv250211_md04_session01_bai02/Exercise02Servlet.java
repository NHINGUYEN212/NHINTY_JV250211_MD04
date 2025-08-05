package com.example.tsu_jv250211_md04_session01_bai02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "exercise02Servlet", value = "/exercise02")
public class Exercise02Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", 1);
        request.setAttribute("name", "Huấn");
        request.setAttribute("email", "huanrose@gmail.com");
        request.setAttribute("age", 18);
        request.getRequestDispatcher("/exercise02.jsp").forward(request, response);


    }
}
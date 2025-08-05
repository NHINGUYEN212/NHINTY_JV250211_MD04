package com.example.tsu_jv250211_md04_session01_bai01;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "exercise01Servlet", value = "/exercise01")
public class Exercise01Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String currentTime = LocalDateTime.now().format(dtf);
        request.setAttribute("time", currentTime);
        request.getRequestDispatcher("/exercise01.jsp").forward(request, response);

    }
}
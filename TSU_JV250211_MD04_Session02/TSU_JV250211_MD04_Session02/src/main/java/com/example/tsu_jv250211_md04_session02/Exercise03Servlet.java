package com.example.tsu_jv250211_md04_session02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "exercise03Servlet", value = "/exercise03")
public class Exercise03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/exercise03.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        double firstNumber = Double.parseDouble(request.getParameter("first-number"));
        double secondNumber = Double.parseDouble(request.getParameter("second-number"));
        String operation = request.getParameter("operation");
        double result = 0;
        String message = "";
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    message = "You don't divide for 0!";
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
        }
        request.setAttribute("result", message.isEmpty() ? result : message);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
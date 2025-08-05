package com.example.tsu_jv250211_md04_session01_bai03;

import entity.Customer;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "exercise03Servlet", value = "/exercise03")
public class Exercise03Servlet extends HttpServlet {
    private final List<Customer> customers = new ArrayList<Customer>();
    @Override
    public void init() throws ServletException {
        customers.add(new Customer(1,"Nguyễn Văn A", LocalDate.of(1983,8,20),"Hà Nội","https://avatar.iran.liara.run/public/41"));
        customers.add(new Customer(2,"Đào Văn B", LocalDate.of(1999,2,11),"Hà Nội","https://avatar.iran.liara.run/public/17"));
        customers.add(new Customer(3,"Phạm Thị C", LocalDate.of(1995,4,25),"Hà Nội","https://avatar.iran.liara.run/public/54"));
        customers.add(new Customer(4,"Bàng Trọng D", LocalDate.of(1985,1,12),"Hà Nội","https://avatar.iran.liara.run/public/31"));
        customers.add(new Customer(5,"Nguyễn Xuân E", LocalDate.of(1998,7,22),"Hà Nội","https://avatar.iran.liara.run/public/2"));
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/exercise03.jsp").forward(request, response);


    }


}
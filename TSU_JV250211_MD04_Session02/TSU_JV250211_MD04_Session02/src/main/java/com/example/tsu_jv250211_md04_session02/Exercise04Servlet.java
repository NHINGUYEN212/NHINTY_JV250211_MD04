package com.example.tsu_jv250211_md04_session02;

import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "exercise04Servlet", value = "/exercise04")
public class Exercise04Servlet extends HttpServlet {
    private final List<Product> products = new ArrayList<Product>();
    @Override
    public void init() throws ServletException {
        products.add(new Product(1,"Gạo Lứt","Mô tả gạo lứt",20000,"https://login.medlatec.vn//ImagePath/images/20211127/20211127_gao-lut-co-tot-khong-2.png"));
        products.add(new Product(2,"Lạc Rang","Mô tả lạc rang",5000,"https://danviet.ex-cdn.com/files/f1/296231569849192448/2022/8/5/lac-rang-muoi-1659687349531461745645.jpeg"));
        products.add(new Product(3,"Muối Vừng","Mô tả muối vừng",50000,"https://cf.shopee.vn/file/85a100e6c30d8fa0535802b12f179cb1"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("products", products);
        request.getRequestDispatcher("/exercise04.jsp").forward(request, response);
    }
}
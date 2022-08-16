package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.dao.ProductDAO;
import com.chukwuma.commerceweb.util.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductPriceUpdatedServlet", value = "/ProductPriceUpdatedServlet")
public class ProductPriceUpdatedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String name = request.getParameter("product-name");
            Double price = Double.valueOf(request.getParameter("product-price"));
            ProductDAO productDAO = new ProductDAO(DBConnection.getConnection());
            productDAO.updatePrice(name, price);
            out.println("The Price of " + name + " has been set to " + price + " and updated in the store.");
        }
    }
}

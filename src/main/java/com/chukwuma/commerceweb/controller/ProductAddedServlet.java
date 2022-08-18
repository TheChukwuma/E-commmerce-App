package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.dao.ProductDAO;
import com.chukwuma.commerceweb.model.Product;
import com.chukwuma.commerceweb.util.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.jsp.el.ScopedAttributeELResolver;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductAddedServlet", value = "/ProductAddedServlet")
public class ProductAddedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String name = request.getParameter("product-name");
            String category = request.getParameter("product-category");
            Double price = Double.valueOf(request.getParameter("product-price"));
            Long quantity = Long.valueOf(request.getParameter("product-quantity"));
            String img = request.getParameter("image");
            Product product = new Product(name, category, price, quantity);
            ProductDAO productDAO = new ProductDAO(DBConnection.getConnection());
            productDAO.insertProducts(product);
            out.println(product.getName() + " has been added to the store.");
        }

    }
}



package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.dao.ProductDAO;
import com.chukwuma.commerceweb.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductQuantityUpdatedServlet", value = "/ProductQuantityUpdatedServlet")
public class ProductQuantityUpdatedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String name = request.getParameter("product-name");
            Long qty = Long.valueOf(request.getParameter("product-quantity"));
            ProductDAO productDAO = new ProductDAO(DBConnection.getConnection());
            productDAO.updateQuantity(name, qty);
            out.println("Quantity of " + name + " has been set to " + qty + " and updated in the store.");
        }
    }
}

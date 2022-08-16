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

@WebServlet("/ProductDeletedServlet")
public class ProductDeletedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            System.out.println("delete servlet");
            String name = request.getParameter("product-name");
            ProductDAO productDAO = new ProductDAO(DBConnection.getConnection());
            productDAO.deleteAProduct(name);
            out.println( name + " has been deleted from the store.");
        }
    }
}

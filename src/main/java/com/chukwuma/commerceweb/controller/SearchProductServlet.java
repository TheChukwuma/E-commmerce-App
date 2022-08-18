package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.dao.ProductDAO;
import com.chukwuma.commerceweb.model.Product;
import com.chukwuma.commerceweb.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearchProductServlet", value = "/search-product-servlet")
public class SearchProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String name = request.getParameter("search");
            ProductDAO productDAO = new ProductDAO(DBConnection.getConnection());
            List<Product> searchList = productDAO.searchByNameOrCategory(name);
//            out.println(searchList);
            HttpSession session = request.getSession();
            session.setAttribute("search",searchList);
            response.sendRedirect("search-index.jsp");
        }

    }
}

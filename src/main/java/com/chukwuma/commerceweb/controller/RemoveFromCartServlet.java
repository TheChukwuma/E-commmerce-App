package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.model.Cart;
import com.chukwuma.commerceweb.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RemoveFromCartServlet", value = "/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

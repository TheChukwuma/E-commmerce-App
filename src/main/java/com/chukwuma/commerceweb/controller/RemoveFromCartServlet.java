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
        try(PrintWriter out = response.getWriter()){
            int id = Integer.parseInt(request.getParameter("id"));
            if (id != 0){
                List<Cart> cart_list = (List<Cart>) request.getSession().getAttribute("cart-list");
                if (!cart_list.isEmpty()){
                    for (Cart cart : cart_list){
                        if(cart.getId() == id){
                            cart_list.remove(cart);
                            break;
                        }
                    }
                }response.sendRedirect("cart.jsp");
            }else{
                response.sendRedirect("Cart.jsp");
        }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

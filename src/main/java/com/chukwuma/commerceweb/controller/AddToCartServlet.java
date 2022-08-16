package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.model.Cart;
import com.chukwuma.commerceweb.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try(PrintWriter out = response.getWriter()){
            ArrayList<Cart> cartList = new ArrayList<>();

            int id = Integer.parseInt(request.getParameter("id"));
            Cart cm = new Cart();

            cm.setId(id);
            cm.setProductQuantity(1);

            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

            if (cart_list == null){
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("index.jsp");
            } else{
                cartList = cart_list;
                boolean exists =  false;
                for (Cart c : cart_list){
                    if(c.getId() == id){
                        exists = true;
                        out.println("<h3 style='color:crimson; text-align:center'>Item already exists in cart. " +
                                "<a href='cart.jsp'>Go To Cart</a></h3>");
                        out.println("<h3 style='color:black; text-align:center'><a href='index.jsp'>Go Home</a></h3>");

                    }

                }
                if(!exists){
                    cartList.add(cm);
                    response.sendRedirect("index.jsp");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

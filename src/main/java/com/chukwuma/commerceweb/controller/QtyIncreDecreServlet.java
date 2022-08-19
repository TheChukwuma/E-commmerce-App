package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QtyIncreDecreServlet", value = "/QtyIncreDecreServlet")
public class QtyIncreDecreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try(PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));

            System.out.println(action);
            System.out.println(id);
            HttpSession session = request.getSession();
            List<Cart> cartList1 = (ArrayList<Cart>) session.getAttribute("cart-list");

            if (action != null && id >= 1) {
                for (Cart c: cartList1) {
                    if (c.getId() == id) {
                        if (action.equals("incre")) {
                            int qty = c.getProductQuantity();
                            qty++;
                            c.setProductQuantity(qty);
                            response.sendRedirect("cart.jsp");
                        }
                        else if (action.equals("decre")) {
                            if (c.getProductQuantity() > 1) {
                                int qty = c.getProductQuantity();
                                qty--;
                                c.setProductQuantity(qty);
                                response.sendRedirect("cart.jsp");
                            }response.sendRedirect("cart.jsp");

                        }

                    }
                }
            }
            else {
                response.sendRedirect("cart.jsp");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


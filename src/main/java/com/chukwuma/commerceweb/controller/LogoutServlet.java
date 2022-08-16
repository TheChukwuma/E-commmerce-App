package com.chukwuma.commerceweb.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", value = "/log-out")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try(PrintWriter out = response.getWriter()){
            if (request.getSession().getAttribute("auth") != null){
                request.getSession().removeAttribute("auth");
                response.sendRedirect("login-user.jsp");
            }else if(request.getSession().getAttribute("auth-admin") != null){
                request.getSession().removeAttribute("auth-admin");
                response.sendRedirect("login-admin.jsp");
            }
            else{
                response.sendRedirect("index.jsp");
                out.println("how are you");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

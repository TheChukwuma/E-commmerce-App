package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.dao.AdminDAO;
import com.chukwuma.commerceweb.dao.UserDAO;
import com.chukwuma.commerceweb.model.User;
import com.chukwuma.commerceweb.util.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String email = request.getParameter("login-admin-email");
            String password = request.getParameter("login-admin-password");
            int adminID = Integer.parseInt(request.getParameter("login-admin-id"));
            AdminDAO adminDao = new AdminDAO(DBConnection.getConnection());
            String loginResult = adminDao.adminLogin(email, password, adminID);
            User admin = new User(email, password, adminID);
            if (loginResult.equals("Successful login")){
                request.getSession().setAttribute("auth-admin", admin);
                response.sendRedirect("index.jsp");
            }else if (loginResult.equals("Failed login")){
                out.println("login failed");
                response.sendRedirect("login-admin.jsp");
                out.println("login failed");
                out.println("Please try again");
            } else {out.println("my algorithm failed");}

        }
    }
}

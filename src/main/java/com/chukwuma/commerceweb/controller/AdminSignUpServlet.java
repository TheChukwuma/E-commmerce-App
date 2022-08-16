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

@WebServlet(name = "AdminSignUpServlet", value = "/AdminSignUpServlet")
public class AdminSignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String firstName = request.getParameter("first-name");
            String lastName = request.getParameter("last-name");
            String email = request.getParameter("signup-admin-email1");
            String password = request.getParameter("signup-admin-password");
            String phoneNumber = request.getParameter("phone-number");
            int adminID = Integer.parseInt(request.getParameter("admin-id"));
            AdminDAO adminDao = new AdminDAO(DBConnection.getConnection());
            User admin = new User(firstName, lastName, email, password, phoneNumber, adminID);
            adminDao.adminSignUp(admin);
            out.println(admin);
            //response.sendRedirect("login-admin.jsp");
        }
    }
}

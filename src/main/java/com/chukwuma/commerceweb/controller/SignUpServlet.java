package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.util.DBConnection;
import com.chukwuma.commerceweb.dao.UserDAO;
import com.chukwuma.commerceweb.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignUpServlet", value = "/signup-servlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String firstName = request.getParameter("first-name");
            String lastName = request.getParameter("last-name");
            String email = request.getParameter("signup-user-email1");
            String password = request.getParameter("signup-user-password");
            String phoneNumber = request.getParameter("phone-number");
            UserDAO userDao = new UserDAO(DBConnection.getConnection());
            User user = new User(firstName, lastName, email, password, phoneNumber);
            userDao.signUp(user);
            out.println("Dear " + user.getFirst_name() + ", you have successfully signed up!");
            Thread.sleep(2000);
            response.sendRedirect("login-user.jsp");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

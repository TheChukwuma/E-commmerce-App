package com.chukwuma.commerceweb.controller;

import com.chukwuma.commerceweb.util.DBConnection;
import com.chukwuma.commerceweb.dao.UserDAO;
import com.chukwuma.commerceweb.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/user-login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("login-user.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            //out.println("this is login servlet");
            String email = request.getParameter("login-user-email");
            String password = request.getParameter("login-user-password");
            User user = new User(email, password);
            UserDAO userDao = new UserDAO(DBConnection.getConnection());
            String loginResult = userDao.userLogin(email, password);
            if (loginResult.equals("Successful login")){
               // out.println("User logged in successfully!");
                request.getSession().setAttribute("auth", user);
                response.sendRedirect("index.jsp");
            }else if (loginResult.equals("Failed login")){
                out.println("login failed");
                response.sendRedirect("login-user.jsp");
                out.println("login failed");
                out.println("Please try again");
            } else {out.println("my algorithm failed");}

        }
    }
}

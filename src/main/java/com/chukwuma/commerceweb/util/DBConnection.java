package com.chukwuma.commerceweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbage_electronics","root","EGwu12!@");
                System.out.println("connected");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }



}

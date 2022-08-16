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

//    private static Connection trialConnection = null;
//
//    public static Connection getTrialConnection(){
//        if(trialConnection==null){
//            try{
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                trialConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_database","root","EGwu12!@");
//                System.out.println("connected");
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return trialConnection;
//    }

}

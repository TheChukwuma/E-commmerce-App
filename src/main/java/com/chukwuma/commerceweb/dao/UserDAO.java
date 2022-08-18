package com.chukwuma.commerceweb.dao;

import com.chukwuma.commerceweb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final Connection connection;
    private PreparedStatement pst;
    private ResultSet resultSet;
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            " (first_name, last_name, email, password, phone_number) VALUES" +
            " (?,?,?,?,?);";
    private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = "SELECT id, first_name, email, password FROM users WHERE email = ? AND password = ?;";


    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public UserDAO(Connection connection, PreparedStatement pst, ResultSet resultSet) {
        this.connection = connection;
        this.pst = pst;
        this.resultSet = resultSet;
    }


    public String userLogin(String email, String password){
        String result = "";

        try{
            pst = this.connection.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD);
            pst.setString(1, email);
            pst.setString(2, password);
            resultSet = pst.executeQuery();
            System.out.println(pst);
            if (!resultSet.next()){result = "Failed login";}
            else{
                result = "Successful login";
            }

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
       return result;
    }

    //The video named this method insert user
    public String signUp(User user){

        try{
            pst = this.connection.prepareStatement(INSERT_USERS_SQL);
            pst.setString(1, user.getFirst_name());
            pst.setString(2, user.getLast_name());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getPhone_number());
            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Registration Successful ";
    }

}

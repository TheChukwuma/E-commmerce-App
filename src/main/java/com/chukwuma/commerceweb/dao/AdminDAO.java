
package com.chukwuma.commerceweb.dao;

import com.chukwuma.commerceweb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    private final Connection connection;
    private PreparedStatement pst;
    private ResultSet resultSet;
    private static final String INSERT_ADMIN_USER_SQL = "INSERT INTO users (first_name, last_name, email, password, phone_number, admin_id) VALUES (?,?,?,?,?,?);";
    private static final String SELECT_USER_BY_EMAIL_PASSWORD_AND_ID = "SELECT first_name, email, admin_id FROM users  WHERE email =? AND password=? AND admin_id = ?;";


    public AdminDAO(Connection connection) {
        this.connection = connection;
    }

    public AdminDAO(Connection connection, PreparedStatement pst, ResultSet resultSet) {
        this.connection = connection;
        this.pst = pst;
        this.resultSet = resultSet;
    }

    public String adminLogin(String email, String password, int adminID){
        String result = "";
        try{
            pst = this.connection.prepareStatement(SELECT_USER_BY_EMAIL_PASSWORD_AND_ID);
            pst.setString(1, email);
            pst.setString(2, password);
            pst.setInt(3, adminID);
            resultSet = pst.executeQuery();
            System.out.println("firstHello");

            if (resultSet.next()) {
                result = "Successful login";
            } else {result = "Failed login";}

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    //The video named this method insert user
    public String adminSignUp(User user){
        int num = 0;
        try{
            pst = this.connection.prepareStatement(INSERT_ADMIN_USER_SQL);
            pst.setString(1, user.getFirst_name());
            pst.setString(2, user.getLast_name());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getPhone_number());
            pst.setInt(6, user.getAdminID());
            num = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Registration Successful " + num;
    }

}

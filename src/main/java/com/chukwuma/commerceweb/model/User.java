package com.chukwuma.commerceweb.model;

import com.chukwuma.commerceweb.enums.UserRole;

public class User {
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_number;
    private int adminID;

    public User(){
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String first_name, String email, int adminID) {
        this.first_name = first_name;
        this.email = email;
        this.adminID = adminID;
    }

    public User(int user_id, String first_name, String email, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.email = email;
        this.password = password;
    }

    public User(int user_id, String first_name, String email, int adminID) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.email = email;
        this.adminID = adminID;
    }

    public User(String first_name, String last_name, String email, String password, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
    }

    public User(String first_name, String last_name, String email, String password, String phone_number, int adminID) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.adminID = adminID;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}

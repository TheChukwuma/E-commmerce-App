<%@ page import="com.chukwuma.commerceweb.model.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chukwuma.commerceweb.util.DBConnection" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 09/08/2022
  Time: 01:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null){
        request.setAttribute("cart_list", cart_list);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>ADMIN SIGNUP PAGE</title>
    <%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="includes/nav.jsp"%>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">Create Admin Account</div>
        <div class="card-body">
            <form action="AdminSignUpServlet" method="post">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" name="first-name" placeholder="First Name" required><br>
                    <input type="text" class="form-control" name="last-name" placeholder="Last Name" required>
                </div>
                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" class="form-control" name="signup-admin-email1" placeholder="Enter your email" required><br>
                    <input type="email" class="form-control" name="signup-admin-email2" placeholder="Enter email again" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" id="admin-password" name="signup-admin-password" placeholder="********" required>
                    <input type="checkbox" onclick="myFunction()">Show Password
                </div>
                <div class="form-group">
                    <label>Telephone Number</label>
                    <input type="tel" class="form-control" name="phone-number" placeholder="Telephone">
                </div>
                <div class="form-group">
                    <label>Admin ID</label>
                    <input type="number" class="form-control" name="admin-id" placeholder="Admin ID" required>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Create Account</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%out.println(DBConnection.getConnection());%>

<%@include file="includes/footer.jsp"%>
<script>
    function myFunction() {
        var x = document.getElementById("admin-password");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>
</body>
</html>

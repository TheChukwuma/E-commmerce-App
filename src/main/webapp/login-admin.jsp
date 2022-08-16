<%@ page import="com.chukwuma.commerceweb.model.Cart" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 08/08/2022
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null){
        request.setAttribute("cart_list", cart_list);
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>LOGIN</title>
    <%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="includes/nav.jsp"%>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">Admin Login</div>
        <div class="card-body">
            <form action="AdminLoginServlet" method="post">
                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" class="form-control" name="login-admin-email" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" id="admin-password" name="login-admin-password" placeholder="********"   required >
                    <input type="checkbox" onclick="myFunction()"> Show Password
                </div>
                <div class="form-group">
                    <label>Admin ID</label>
                    <input type="text" class="form-control" name="login-admin-id" placeholder="Enter your admin ID" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
            <br>
            <div class="text-center">
                <a href="signup-admin.jsp" target=""><button class="btn btn-primary">Create New Account </button></a>
            </div>
        </div>
    </div>
</div>



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
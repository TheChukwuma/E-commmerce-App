<%@ page import="com.chukwuma.commerceweb.model.User" %>
<%@ page import="com.chukwuma.commerceweb.dao.ProductDAO" %>
<%@ page import="com.chukwuma.commerceweb.util.DBConnection" %>
<%@ page import="com.chukwuma.commerceweb.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 13/08/2022
  Time: 01:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
[Yesterday 13:44] Oluwaseun Ogundana
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%><%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    ProductDAO pd = new ProductDAO(DBConnection.getConnection());
    Map<String, List<Product>> products = pd.getAllProducts("category");
    ArrayList<Product> cart_list = (ArrayList<Product>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
%><!DOCTYPE html>
<html>
<head>
    <title>SHOE EXPRESS</title>
    <%@include file="/includes/header.jsp"%></head>
<body>
<%@include file="/includes/nav.jsp"%><div class="container">
    <div class="card-header my-3">All Products</div>
    <div class="row">
        <%
            if (!products.isEmpty()) {
                for (Product p : products) {
        %>            <div class="col-md-3 my-3">
        <div class="card w-100">
            <img class="card-img-top" src="Products/<%=p.getImage() %>"
                 alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title"><%=p.getName() %></h5>
                <h6 class="price">Price: $<%=p.getPrice() %></h6>
                <h6 class="category">Category: <%=p.getCategory() %></h6>
                <div class="mt-3 d-flex justify-content-between">
                    <a class="btn btn-dark" href="AddToCartServlet?id=<%=p.getId()%>">Add to Cart</a> <a
                        class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
                </div>
            </div>
        </div>
    </div>
        <%
                }
            } else {
                out.println("There is no product");
            }
        %>        </div>
</div>
<br/>
<% out.print(DBConnection.getConnection()); %><%@include file="/includes/footer.jsp"%></body>
</html>



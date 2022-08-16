<%@ page import="com.chukwuma.commerceweb.model.Cart" %>
<%@ page import="java.util.ArrayList" %><%-- Created by IntelliJ IDEA.
  User: decagon
  Date: 11/08/2022
  Time: 00:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null){
        request.setAttribute("cart_list", cart_list);
    }
%>

<!Doctype html>
<html>
<head>
    <title>Product Page</title>
    <%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="includes/nav.jsp"%>

<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">ADD PRODUCTS TO STORE</div>
        <div class="card-body">
            <form action="ProductAddedServlet" method="post">
                <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" class="form-control" name="product-name" placeholder="Product Name" required>
                </div>
                <div class="form-group">
                    <label>Product Category</label>
                    <select name="product-category" id="audio" class="form-control">
                        <option value="Microphone">Microphone</option>
                        <option value="Loudspeaker">Loudspeaker</option>
                        <option value="Amplifier">Amplifier</option>
                        <option value="Home Theatre">Home Theatre</option>
                        <option value="Mixing Console">Mixing Console</option>
                        <option value="Keyboard">Keyboard</option>
                        <option value="DSP">DSP</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" class="form-control" name="product-price" placeholder="Product Price" required>
                </div>
                <div class="form-group">
                    <label>Quantity</label>
                    <input type="number" class="form-control" name="product-quantity" placeholder="Product Quantity" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">ADD</button>
                </div>
            </form>

        </div>
    </div>
</div>

<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">UPDATE PRODUCT PRICE</div>
        <div class="card-body">
            <form action="ProductPriceUpdatedServlet" method="post">
                <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" class="form-control" name="product-name" placeholder="Product Name" required>
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" class="form-control" name="product-price" placeholder="Product New Price" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">UPDATE</button>
                </div>
            </form>

        </div>
    </div>
</div>

<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">UPDATE PRODUCT QUANTITY</div>
        <div class="card-body">
            <form action="ProductQuantityUpdatedServlet" method="post">
                <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" class="form-control" name="product-name" placeholder="Product's Name" required>
                </div>
                <div class="form-group">
                    <label>Quantity</label>
                    <input type="number" class="form-control" name="product-quantity" placeholder="Product's New Quantity" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">UPDATE</button>
                </div>
            </form>

        </div>
    </div>
</div>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">DELETE PRODUCT FROM STORE</div>
        <div class="card-body">
            <form action="ProductDeletedServlet" method="post">
                <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" class="form-control" name="product-name" placeholder="Product Name" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">DELETE</button>
                </div>
            </form>
        </div>
    </div>
</div>


<%@include file="includes/footer.jsp"%>
</body>
</html>

<%@ page import="com.chukwuma.commerceweb.util.DBConnection" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.chukwuma.commerceweb.model.User" %>
<%@ page import="com.chukwuma.commerceweb.dao.ProductDAO" %>
<%@ page import="com.chukwuma.commerceweb.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.chukwuma.commerceweb.model.Cart" %>
<%@ page import="java.util.ArrayList" %>


<%
    ProductDAO pd = new ProductDAO(DBConnection.getConnection());
    List<Product> productList = pd.getAllProductsInStore();

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null){
        request.setAttribute("cart_list", cart_list);
    }
%>
<!doctype html>
<html lang="en">
<head>
    <title>HOME PAGE</title>
    <%@include file="includes/header.jsp"%>
    <meta charset="utf-8">
    <style>
        h4 {
            color: #5c209a;
        }
    </style>
</head>
<body>
<%@include file="includes/nav.jsp"%>

<br>
<div class="container">
    <h4>Babbage Sound And Audio Reinforcements</h4>
    <div class="card-header my-3">All Products</div>
    <div class="row my-3">
        <%
            if (!productList.isEmpty()){
                for (Product product : productList){ %>
                    <div class="col-md-3 my-3 mx-3 justify-content-between">
                        <div class="card w-150" style="width: 18rem;">
                            <img class="card-img-top-centre" src="product-images/<%= product.getImage()%>" alt="Card image cap">
                            <div class="card-body">
<%--                                <h5 class="card-title">Card: <%= product.getId()%></h5>--%>
                                <h6 class="card-title">Product: <%= product.getName()%></h6>
                                <h6 class="price">Price: $<%=product.getPrice()%> </h6>
                                <h6 class="category">Category: <%=product.getCategory()%></h6>
                                <div class="mt-3 d-flex text-centre justify-content-around">
                                    <a href="AddToCartServlet?id=<%=product.getId()%>" style="margin: 2px" class="btn btn-dark">Add to Cart</a>
                                    <a href="#" style="margin: 2px" class="btn btn-primary">Like</a>
                                </div>
                            </div>
                        </div>
                    </div>
            <%  }
            } %>
    </div>
</div>

</body>
</html>



<%@include file="includes/footer.jsp"%>
</body>
</html>
<%@ page import="com.chukwuma.commerceweb.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chukwuma.commerceweb.model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.chukwuma.commerceweb.dao.ProductDAO" %>
<%@ page import="com.chukwuma.commerceweb.util.DBConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if(auth!=null){
        response.sendRedirect("index.jsp");
    }

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null){
        ProductDAO pd = new ProductDAO(DBConnection.getConnection());
        cartProduct = pd.getCartProducts(cart_list);
        request.setAttribute("cart_list", cart_list);
    }
    double totalPrice = 0.0;
%>
<!DOCTYPE html>
<html>
<head>
    <title>CART</title>
    <%@include file="includes/header.jsp"%>
    <style type="text/css">
        .table tbody td {
            vertical-align: middle;
        }
        .btn-incre, .btn-decre {
            box-shadow: none;
            font-size: 25px;
            color: #66dfec;
        }
    </style>
</head>
<body>
    <%@include file="includes/nav.jsp"%>
    <div class="container">
        <table class="table table-light">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col">Buy Now</th>
                <th scope="col">Cancel</th>
            </tr>
            </thead>
            <tbody>
            <%if (cart_list != null){
                for(Cart c : cartProduct){
            totalPrice+=c.getPrice();
            %>
                <tr>
                    <td><%=c.getName()%></td>
                    <td><%=c.getCategory()%></td>
                    <td>$<%=c.getPrice()%></td>
                    <td>
                        <form action="" method="post" class="form-inline">
                            <input type="hidden" name="id" value="<%=c.getId() %>" class="form-input">
                            <div class="form-group d-flex justify-content-between">
                                <a class="btn btn-sm btn-decre" href="QtyIncreDecreServlet?action=decre&id=<%= c.getId()%>"><i class="fas fa-minus-square"></i> </a>
                                <input type="text" name="quantity" class="form-control" value="<%=c.getProductQuantity()%>" readonly>
                                <a class="btn btn-sm btn-incre" href="QtyIncreDecreServlet?action=incre&id=<%= c.getId()%>" ><i class="fas fa-plus-square"></i> </a>
                            </div>
                        </form>
                    </td>
                    <td><a class="btn btn-sm btn-danger btn-danger" href="RemoveFromCartServlet?id=<%=c.getId()%>">Remove</a> </td>
                </tr>
            <%    }
            }
            %>
            </tbody>
        </table>
        <div class="d-flex py-3"><h3>Total Price: $<%=totalPrice%></h3><a class="mx-3 btn btn-primary" href="#">Check Out</a> </div>
    </div>
    <%@include file="includes/footer.jsp"%>
</body>
</html>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">BABBAGE ELECTRONICS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
<%--                <li class="nav-item active">--%>
<%--                    <a class="nav-link" href="index.jsp" >Home <span class="sr-only">(current)</span></a>--%>
<%--                </li>--%>


                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="cart.jsp">Cart <span class="badge badge-danger">${cart_list.size()}</span> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="log-out">Logout</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="index.jsp" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Account
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="login-user.jsp">User Login</a>
                            <a class="dropdown-item" href="login-admin.jsp">Admin Login</a>
                        </div>
                    </li>


                <li class="nav-item">
                    <a class="nav-link" href="product.jsp">Product</a>
                </li>



            </ul>
            <form action="search-product-servlet" method="post" class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search product" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
            </form>
        </div>
    </div>
</nav>
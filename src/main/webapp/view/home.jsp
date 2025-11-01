<%@ page import="model.Product" %>
<%@ page import="dao.ProductDAO" %>
<%@ page import="java.util.List" %>
<%@ include file="home_navbar.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<html>
<head>
    <title>Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card-img-top {
            object-fit: cover;
            height: 200px;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center mb-4">🛒 Explore Products</h2>
    <% String msg = (String) request.getAttribute("msg");
       String color = (String) request.getAttribute("color");
       if (msg != null) { %>
       <div class="alert alert-<%= color %> text-center"><%= msg %></div>
    <% } %>

    <div class="row">
        <%
            List<Product> products = ProductDAO.getAllProducts();
            for (Product p : products) {
        %>
        <div class="col-md-4 mb-4">
            <div class="card shadow-sm">
                <img src="<%= request.getContextPath() + "/" + p.getImage() %>" class="card-img-top" alt="Product">
                <div class="card-body">
                    <h5 class="card-title"><%= p.getName() %></h5>
                    <p class="card-text"><%= p.getDescription() %></p>
                    <p class="text-primary"><strong>₹<%= p.getPrice() %></strong></p>
                    <a href="<%= request.getContextPath() %>/addToCart?productId=<%= p.getId() %>" class="btn btn-outline-primary w-100">Buy Now</a>
                </div>
            </div>
        </div>
        <% } %>
    </div>
</div>
</body>
</html>

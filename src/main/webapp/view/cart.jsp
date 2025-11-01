<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Cart" %>

<html>
<head>
    <title>Your Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="home_navbar.jsp" %>


<%
    if (username == null) {
%>
    <div class="alert alert-warning text-center mt-4">Please login to view your cart.</div>
    <% return; } %>

<%
    List<Cart> cartList = (List<Cart>) request.getAttribute("cartList");
%>

<div class="container mt-4">
    <h3>Your Cart</h3>

    <% if (cartList == null || cartList.isEmpty()) { %>
        <div class="alert alert-info text-center">Your cart is empty.</div>
    <% } else {
        double total = 0;
        for (Cart c : cartList) {
            total += c.getPrice() * c.getQuantity();
    %>
        <div class="card mb-3 shadow-sm">
            <div class="row g-0">
                <div class="col-md-2">
                    <img src="<%= request.getContextPath() + "/" + c.getImage() %>" class="img-fluid rounded-start" style="height: 100px; object-fit: cover;">
                </div>
                <div class="col-md-10">
                    <div class="card-body">
                        <h5 class="card-title"><%= c.getProductName() %></h5>
                        <p class="card-text">Price: ₹<%= c.getPrice() %></p>

                        <form action="<%= request.getContextPath() %>/updateCart" method="post" class="d-inline">
                            <input type="hidden" name="productId" value="<%= c.getProductId() %>"/>
                            <button type="submit" name="quantity" value="<%= c.getQuantity() - 1 %>" class="btn btn-outline-secondary btn-sm" <%= c.getQuantity() <= 1 ? "disabled" : "" %>>−</button>
                            <span class="mx-2"><%= c.getQuantity() %></span>
                            <button type="submit" name="quantity" value="<%= c.getQuantity() + 1 %>" class="btn btn-outline-secondary btn-sm">+</button>
                        </form>

                        <form action="<%= request.getContextPath() %>/deleteCartItem" method="get" class="d-inline">
                            <input type="hidden" name="productId" value="<%= c.getProductId() %>"/>
                            <button type="submit" class="btn btn-danger btn-sm ms-3">🗑️ Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    <% } %>

    <div class="alert alert-success text-end">
        <strong>Total: ₹<%= total %></strong>
    </div>

    <a href="<%= request.getContextPath() %>/view/checkout.jsp" class="btn btn-primary w-100">Proceed to Checkout</a>

    <% } %>
</div>

</body>
</html>

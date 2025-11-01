<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="home_navbar.jsp" %>
<%
    if (username == null) {
%>
    <div class="alert alert-warning text-center mt-4">Please login to continue.</div>
<% return; } %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h3 class="mb-4 text-center">Confirm Your Order</h3>
    <div class="text-center">
        <form action="<%= request.getContextPath() %>/view/placeorder.jsp" method="post">
            <p>Click the button below to confirm your order.</p>
            <button class="btn btn-success btn-lg">✅ Place Order</button>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

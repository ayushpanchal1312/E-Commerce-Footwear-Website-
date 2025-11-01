<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="home_navbar.jsp" %>

<html>
<head>
    <title>Order Success</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="text-center">
        <img src="<%= request.getContextPath() %>/image/success.gif" width="150" alt="Success" />
        <h2 class="text-success mt-4">🎉 Order Placed Successfully!</h2>
        <p class="lead">Thank you for your purchase.</p>
        <p>Your items will be delivered to your address soon.</p>
        <a href="<%= request.getContextPath() %>/view/home.jsp" class="btn btn-primary mt-3">Continue Shopping</a>
    </div>
</div>

</body>
</html>

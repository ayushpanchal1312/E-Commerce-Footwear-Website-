<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="home_navbar.jsp" %>

<%
    if (username == null) {
%>
    <div class="alert alert-warning text-center mt-4">Please login to continue.</div>
<% return; } %>

<!DOCTYPE html>
<html>
<head>
    <title>Place Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center text-success mb-4">Review & Place Your Order</h2>

    <form action="<%= request.getContextPath() %>/placeOrder" method="post" class="mx-auto" style="max-width: 600px;">
        <div class="mb-3">
            <label for="name" class="form-label">Full Name</label>
            <input type="text" class="form-control" name="name" required placeholder="Enter your name">
        </div>

        <div class="mb-3">
            <label for="address" class="form-label">Shipping Address</label>
            <textarea class="form-control" name="address" rows="3" required placeholder="Enter your address"></textarea>
        </div>

        <div class="mb-3">
            <label for="payment" class="form-label">Payment Method</label>
            <select class="form-select" name="payment" required>
                <option value="">Select Payment Method</option>
                <option value="cod">Cash on Delivery</option>
                <option value="upi">UPI</option>
                <option value="card">Credit/Debit Card</option>
            </select>
        </div>

        <div class="text-end">
            <button type="submit" class="btn btn-success">Place Order</button>
            <a href="<%= request.getContextPath() %>/viewCart" class="btn btn-secondary">Back to Cart</a>
        </div>
    </form>
</div>

</body>
</html>

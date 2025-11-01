
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="dao.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>View Products</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container mt-4">
  <h3>All Products</h3>
  <table class="table table-bordered table-striped table-hover">
    <thead class="table-dark">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Desc</th>
      <th>Price</th>
      <th>Image</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<Product> list = ProductDAO.getAllProducts();
      for (Product p : list) {
    %>
    <tr>
      <td><%= p.getId() %></td>
      <td><%= p.getName() %></td>
      <td><%= p.getDescription() %></td>
      <td>₹<%= p.getPrice() %></td>
      <td>
        <img src="<%= request.getContextPath() + "/" + p.getImage() %>" width="70" height="50" style="object-fit:cover"/>
      </td>
      <td>
        <a href="<%= request.getContextPath() %>/deleteProduct?id=<%= p.getId() %>" class="btn btn-danger btn-sm">Delete</a>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
</body>
</html>

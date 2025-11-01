<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%@ include file="navbar.jsp" %>

<html>
<head>
  <title>Add Product</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
  <h3>Add New Product</h3>

  <% String msg = (String) request.getAttribute("msg");
     String color = (String) request.getAttribute("color");
     if (msg != null) { %>
    <div class="alert alert-<%= color %>"><%= msg %></div>
  <% } %>

  <form action="<%= request.getContextPath() %>/addProduct" method="post">
    <div class="mb-3">
      <label>Name:</label>
      <input type="text" name="name" class="form-control">
    </div>
    <div class="mb-3">
      <label>Description:</label>
      <textarea name="desc" class="form-control"></textarea>
    </div>
    <div class="mb-3">
      <label>Price:</label>
      <input type="number" name="price" class="form-control">
    </div>
    <div class="mb-3">
      <label>Image Filename (e.g., shoes.png):</label>
      <input type="text" name="image" class="form-control">
    </div>
    <input type="submit" value="AddProduct" class="btn btn-primary">
  </form>
</div>
</body>
</html>

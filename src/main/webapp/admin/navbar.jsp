<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("name");
    if(username == null){
    response.sendRedirect(request.getContextPath() + "/view/index.jsp");
    return;
    }
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%= request.getContextPath() %>/admin/addProduct.jsp">E-Commerce Admin</a>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/admin/addProduct.jsp">Add Product</a></li>
        <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/admin/viewProducts.jsp">View Products</a></li>
        <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/logout">Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

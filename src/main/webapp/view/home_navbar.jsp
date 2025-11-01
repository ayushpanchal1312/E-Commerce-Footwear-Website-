<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("name");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%= request.getContextPath() %>/view/home.jsp">E-Commerce</a>

    <div class="collapse navbar-collapse">
      <ul class="navbar-nav ms-auto">
        <% if (username != null) { %>
          <li class="nav-item">
            <span class="nav-link text-white">Welcome, <%= username %></span>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="<%= request.getContextPath() %>/viewCart">
              Cart
              <% Integer cartCount = (Integer) session.getAttribute("cartCount");
                 if (cartCount != null && cartCount > 0) { %>
                 <span class="badge bg-warning text-dark"><%= cartCount %></span>
              <% } %>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="<%= request.getContextPath() %>/logout">Logout</a>
          </li>
        <% } else { %>
          <li class="nav-item">
            <a class="nav-link text-white" href="<%= request.getContextPath() %>/view/index.jsp">Login</a>
          </li>
        <% } %>
      </ul>
    </div>
  </div>
</nav>

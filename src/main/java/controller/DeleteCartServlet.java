package controller;

import dao.CartDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCartItem")
public class DeleteCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = (String) req.getSession().getAttribute("name");
        int productId = Integer.parseInt(req.getParameter("productId"));
        CartDAO.deleteCartItem(username, productId);
        resp.sendRedirect(req.getContextPath() + "/viewCart");
    }
}


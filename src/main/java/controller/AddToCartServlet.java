package controller;

import dao.CartDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session  = req.getSession();
        String username = (String) session.getAttribute("name");

        if (username == null){
            String message = "Please login to add items to your cart.";
            String color = "warning";
            req.setAttribute("msg", message);
            req.setAttribute("color", color);
            req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
            return;

        }

        String idStr = req.getParameter("productId");
        if (idStr == null){
            resp.sendRedirect(req.getContextPath() + "/view/home.jsp");
            return;
        }

        try {
            int productId = Integer.parseInt(idStr);

            CartDAO.addOrUpdateCart(username, productId);

            int count = CartDAO.getCartCount(username);
            session.setAttribute("cartCount", count);

            resp.sendRedirect(req.getContextPath() + "/view/home.jsp");

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/view/home.jsp");
        }
    }
}


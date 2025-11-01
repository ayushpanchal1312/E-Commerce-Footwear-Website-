package controller;

import dao.CartDAO;
import dao.OrderDAO;
import model.Cart;
import model.Order;
import model.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("name");

        if (username == null) {
            resp.sendRedirect(req.getContextPath() + "/view/index.jsp");
            return;
        }
        String fullName = req.getParameter("name");
        String address = req.getParameter("address");
        String payment = req.getParameter("payment");

        List<Cart> cartItems = CartDAO.getCartItems(username);

        if (cartItems == null || cartItems.isEmpty()) {
            session.setAttribute("msg", "Your cart is empty!");
            session.setAttribute("color", "warning");
            resp.sendRedirect(req.getContextPath() + "/view/cart.jsp");
            return;
        }

        try {

            int orderId = OrderDAO.insertOrder(fullName,address,payment,username);

            // 🧾 Insert each item into order_items
            for (Cart c : cartItems) {
                OrderItem item = new OrderItem();
                item.setOrderId(orderId);
                item.setProductId(c.getProductId());
                item.setQuantity(c.getQuantity());
                item.setPrice(c.getPrice());

                OrderDAO.insertOrderItem(item);
            }

            CartDAO.clearCart(username);
            session.setAttribute("cartCount", 0);

            resp.sendRedirect(req.getContextPath() + "/view/orderSuccess.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "Order failed. Please try again.");
            req.setAttribute("color", "danger");
            req.getRequestDispatcher("/view/checkout.jsp").forward(req, resp);
        }
    }
}

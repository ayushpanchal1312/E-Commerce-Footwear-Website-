package controller;

import dao.CartDAO;
import model.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewCart")
public class cartServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("name");

        String message,color;
        if (username == null){
            message = "Please login to view cart.";
            color = "warning";
            req.setAttribute("msg",message);
            req.setAttribute("color",color);
            req.getRequestDispatcher("/view/home.jsp").include(req,resp);
        }
        List<Cart> cartitems = CartDAO.getCartItems(username);
        session.setAttribute("cartCount",CartDAO.getCartCount(username));

        req.setAttribute("cartList",cartitems);
        RequestDispatcher rd = req.getRequestDispatcher("/view/cart.jsp");
        rd.forward(req, resp);

    }
}

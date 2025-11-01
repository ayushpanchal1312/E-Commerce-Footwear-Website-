package controller;

import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String message;
        String color;

        try{
            int id = Integer.parseInt(idStr);

            boolean deleted = ProductDAO.deleteProduct(id);
            if(deleted){
                message = "Product deleted successfully!";
                color = "success";
            }else {
                message = "Product deletion failed!";
                color = "danger";
            }
        }catch (NumberFormatException e){
            message = "Product deletion failed!";
            color = "danger";
        }

        req.setAttribute("msg", message);
        req.setAttribute("color", color);
        req.getRequestDispatcher("/admin/viewProducts.jsp").include(req,resp);

    }
}

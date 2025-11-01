package controller;

import dao.LoginDAO;
import model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Login login = LoginDAO.userLogin(username,password);

        if (login != null){
            HttpSession session = req.getSession();
            session.setAttribute("name",username);

            String contextPath = req.getContextPath();


            if ("admin".equals(login.getRole())){
                resp.sendRedirect(contextPath +"/admin/addProduct.jsp");
            }else {
                resp.sendRedirect(contextPath +"/view/home.jsp");
            }
        }else {
            resp.sendRedirect(req.getContextPath()+"/view/index.jsp?error=1");
            resp.getWriter().println("Invalid Username");
        }
    }
}

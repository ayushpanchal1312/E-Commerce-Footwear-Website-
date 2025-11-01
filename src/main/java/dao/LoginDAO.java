package dao;

import ConnectionProvider.ConnectionProvider;
import model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO{

    public static Login userLogin(String username, String password) {

        Login login = null;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "Select role from login where username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                login = new Login();
                login.setUsername(username);
                login.setPassword(password);
                login.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return login;
    }
}

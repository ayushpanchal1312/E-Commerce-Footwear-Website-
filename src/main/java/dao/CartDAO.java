package dao;

import model.Cart;
import ConnectionProvider.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    public static List<Cart> getCartItems(String username) {
        List<Cart> cartList = new ArrayList<>();

        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT c.id, p.id AS product_id, p.name, p.image, p.price, c.quantity " +
                    "FROM cart c JOIN products p ON c.product_id = p.id WHERE c.username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("id"));
                cart.setProductId(rs.getInt("product_id"));
                cart.setProductName(rs.getString("name"));
                cart.setImage(rs.getString("image"));
                cart.setPrice(rs.getDouble("price"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setUsername(username);

                cartList.add(cart);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cartList;
    }

    public static int getCartCount(String username) {
        int count = 0;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT SUM(quantity) FROM cart WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public static void addOrUpdateCart(String username, int productId) {
        try {
            Connection con = ConnectionProvider.getConnection();

            // Check if item already in cart
            String checkSql = "SELECT * FROM cart WHERE username = ? AND product_id = ?";
            PreparedStatement ps = con.prepareStatement(checkSql);
            ps.setString(1, username);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Update quantity if exists
                String updateSql = "UPDATE cart SET quantity = quantity + 1 WHERE username = ? AND product_id = ?";
                ps = con.prepareStatement(updateSql);
                ps.setString(1, username);
                ps.setInt(2, productId);
                ps.executeUpdate();
            } else {
                // Else insert new row
                String insertSql = "INSERT INTO cart (username, product_id, quantity) VALUES (?, ?, ?)";
                ps = con.prepareStatement(insertSql);
                ps.setString(1, username);
                ps.setInt(2, productId);
                ps.setInt(3, 1);
                ps.executeUpdate();
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateQuantity(String username, int productId, int quantity) {
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE cart SET quantity = ? WHERE username = ? AND product_id = ?");
            ps.setInt(1, quantity);
            ps.setString(2, username);
            ps.setInt(3, productId);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteCartItem(String username, int productId) {
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM cart WHERE username=? AND product_id=?");
            ps.setString(1, username);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearCart(String username) {
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM cart WHERE username=?");
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // Optional: remove item, update quantity etc.
}

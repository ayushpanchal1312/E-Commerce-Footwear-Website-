package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ConnectionProvider.ConnectionProvider;
import model.OrderItem;

public class OrderDAO {

    public static int insertOrder(String fullName, String address, String paymentMethod, String username) {
        int orderId = -1;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "INSERT INTO orders (full_name, address, payment_method, username) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, fullName);
            ps.setString(2, address);
            ps.setString(3, paymentMethod);
            ps.setString(4, username);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }



    public static void insertOrderItem(OrderItem item) throws Exception {
        Connection con = ConnectionProvider.getConnection();
        String sql = "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, item.getOrderId());
        ps.setInt(2, item.getProductId());
        ps.setInt(3, item.getQuantity());
        ps.setDouble(4, item.getPrice());
        ps.executeUpdate();
    }
}


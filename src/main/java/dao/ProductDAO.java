package dao;

import model.Product;
import ConnectionProvider.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static boolean addProduct(Product p) {
        boolean success = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "INSERT INTO products (name, description, price, image) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getImage());

            int row = ps.executeUpdate();
            success = row > 0;

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public static List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT * FROM products";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setImage(rs.getString("image"));
                productList.add(p);
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static boolean deleteProduct(int id) {
        boolean success = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int row = ps.executeUpdate();
            success = row > 0;

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}

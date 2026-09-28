import java.sql.*;

public class ProductCRUD {

    static String url = "jdbc:mysql://localhost:3306/student_db";
    static String user = "root";
    static String password = "";

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Database connected successfully!");

            // INSERT
            String insertQuery =
                    "INSERT INTO product (product_no, name, image, price) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setInt(1, 101);
            ps.setString(2, "Laptop");
            ps.setString(3, "laptop.jpg");
            ps.setDouble(4, 55000);

            ps.executeUpdate();

            System.out.println("Product inserted successfully!");

            // RETRIEVE
            String selectQuery = "SELECT * FROM product";

            ps = con.prepareStatement(selectQuery);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nProduct Details:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_no") + " " +
                        rs.getString("name") + " " +
                        rs.getString("image") + " " +
                        rs.getDouble("price")
                );
            }

            // UPDATE
            String updateQuery =
                    "UPDATE product SET price = ? WHERE product_no = ?";

            ps = con.prepareStatement(updateQuery);

            ps.setDouble(1, 60000);
            ps.setInt(2, 101);

            ps.executeUpdate();

            System.out.println("\nProduct updated successfully!");

            // DELETE
            String deleteQuery =
                    "DELETE FROM product WHERE product_no = ?";

            ps = con.prepareStatement(deleteQuery);

            ps.setInt(1, 101);

            ps.executeUpdate();

            System.out.println("Product deleted successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
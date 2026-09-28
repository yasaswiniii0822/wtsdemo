import java.sql.*;

public class jdbcDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Database connected successfully!");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("branch") + " " +
                    rs.getInt("marks")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.sql.*;

class Call {
    public static void main(String args[]) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/callable_db",
                "root",
                ""
            );

            // Prepare CallableStatement
            CallableStatement st =
                con.prepareCall("{? = call addition(?, ?)}");

            // Register return value
            st.registerOutParameter(1, Types.INTEGER);

            // Pass arguments
            st.setInt(2, 10);
            st.setInt(3, 20);

            // Execute function
            st.execute();

            // Get returned value
            int result = st.getInt(1);

            // Display result
            System.out.println("Addition = " + result);

            // Close connection
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
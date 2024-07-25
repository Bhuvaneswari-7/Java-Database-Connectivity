import java.sql.DriverManager;
import java.sql.Connection;

public class Dbcon1 {
    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        Connection con = null;
        try {
            // Establish connection without SSL
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gecdb?user=root&password=bhuvana&useSSL=false"
            );
            System.out.println("Connection established");
        } finally {
            // Close connection in finally block to ensure it always closes
            if (con != null) {
                con.close();
                System.out.println("Connection closed");
            }
        }
    }
}

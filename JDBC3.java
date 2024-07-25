import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class JDBC3
{
    public static void main(String[] args) throws Exception
    {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver is loaded..");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gecdb", "root","bhuvana");        
        Statement pstmt=con.createStatement();
        int r=pstmt.executeUpdate("insert into emp2 values(1,'Krish')");
        System.out.printf("%d rows inserted...",r);
    }
}

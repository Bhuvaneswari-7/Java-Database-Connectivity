import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Jdbc5 
{
    public static void main(String[] args) throws Exception
    {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver is loaded..");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gecdb", "root","bhuvana");        
        PreparedStatement pstmt=con.prepareStatement("insert into emp2 values(?,?)");
        //1st ?  5
        //2nd ?  sivaji
        pstmt.setInt(1, 6);
        pstmt.setString(2, "Narendra");
        int r=pstmt.executeUpdate();
        System.out.printf("%d rows inserted...",r);
    }
}

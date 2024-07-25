import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
public class Jdbc7
{
    public static void main(String[] args) throws Exception
    {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver is loaded..");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gecdb", "root","bhuvana");        
        CallableStatement cstmt=con.prepareCall("{call myproc(?,?)}");
        cstmt.setInt(1, 1);
        cstmt.registerOutParameter(2,Types.VARCHAR);
        cstmt.execute();
        System.out.println(cstmt.getString(2));
    }
}

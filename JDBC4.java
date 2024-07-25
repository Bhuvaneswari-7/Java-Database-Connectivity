import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBC4 
{
    public static void main(String[] args) throws Exception
    {   Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver is loaded..");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gecdb", "root", "bhuvana");
        System.out.println("Connected...");
        //creating Statement object
        Statement stmt=con.createStatement();
        //by using the methods of statement object we can send the sql commands to database
        boolean b=stmt.execute("select * from emp2");
        //execute() method returns if a result set is available
        if(b)
        {
            ResultSet rs=stmt.getResultSet();
            while(rs.next())
            {
                System.out.printf("%-5d %-30s %n",rs.getInt(1),rs.getString(2));
            }
            //getResultSet(); returns the available ResultSet object
        }
        System.out.println(".....Completed......"+b);

    }    
}

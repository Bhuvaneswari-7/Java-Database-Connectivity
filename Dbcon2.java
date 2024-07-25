//1.Statement: to create Statement object we have to call the createStatement() method. We don’t pass command to this method
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
class Dbcon2{
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gecdb?user=root&password=bhuvana");
        System.out.println("connection established"); 
        Statement stmt=con.createStatement();
        stmt.execute("create table emp2(eno int primary key,ename varchar(30))");
        System.out.println("emp table is created");
        con.close();
    }
}
    


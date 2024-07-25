import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
class DAO{
        Connection con;
        DAO() throws ClassNotFoundException,SQLException
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("class loaded");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gecdb", "root", "bhuvana");
            System.out.println("connection established");
        }
        void insert(int eno,String ename)throws SQLException
        {
            Statement stmt=con.createStatement();
            int r=stmt.executeUpdate("insert into emp2 values("+eno+",'"+ename+"')");
            if(r==1)
            {
                System.out.println("inserted");
            }
            else{
                System.out.println("insertion failed");
            }
            }
        void UpdtaeName(int eno,String ename)throws SQLException
        {
            
           String cmd="update emp2 set ename=? Where eno=?";
           PreparedStatement pstmt=con.prepareStatement(cmd);
           pstmt.setString(1,ename);
           pstmt.setInt(2,eno);
           int r=pstmt.executeUpdate();
           if(r==1)
           {
            System.out.println("update name");
           }
           else{
            System.out.println("update name failed");
           }
        }
        void deleteEmp(int eno) throws SQLException
        {
            String cmd="delete from emp2 where eno=?";
            PreparedStatement pstmt=con.prepareStatement(cmd);
            pstmt.setInt(1,eno);
            int r=pstmt.executeUpdate();
            if(r==1)
           {
            System.out.println("deleted ");
           }
           else{
            System.out.println("delete failed");
           }
        }
        void viewAll() throws SQLException
        {
            String cmd="select * from emp2";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(cmd);
            while(rs.next())
            {
                System.out.printf("%-5d %-30s %n",rs.getInt("eno"),rs.getString("ename"));
            }
        }

        }
public class Jdbc6
{
    public static void main(String[] args) throws ClassNotFoundException,SQLException
    {
     DAO dao=new DAO();
     Scanner scan=new Scanner(System.in);
     do{
        System.out.println("1.insert");
        System.out.println("2.update");
        System.out.println("3.delete");
        System.out.println("4.view");
        System.out.println("option:\t");
        int opt=scan.nextInt();
        switch (opt) {
            case 1:
                    dao.insert(30,"virat");
                     break;
            case 2:
                    dao.UpdtaeName(20,"virat kohli");
                    break;
            case 3:
                    dao.deleteEmp(10);
                    break;
            case 4:
                    dao.viewAll();
                    break;
            default: 
                     System.out.println("invalid option");
                     break;
        }
        System.out.println("continue(1/0)");
        int r=scan.nextInt();
        if(r==0)
            break;
}while(true);
}
}
     

    


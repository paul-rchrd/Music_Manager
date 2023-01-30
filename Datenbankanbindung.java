import java.sql.*;
public class Datenbankanbindung {
  public static void main(String[]args)
  {
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music_manager", null, null);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(null);
        while(rs.next())    
        {
            System.out.println();
        }
        con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
  }  
}

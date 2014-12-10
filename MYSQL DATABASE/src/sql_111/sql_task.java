package sql_111;

import java.sql.*;

public class sql_task {
   static final String DB_URL = "jdbc:mysql://localhost:3306/HW6";
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database");
      conn = DriverManager.getConnection(DB_URL,"root", "root");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM person";
      ResultSet rs = stmt.executeQuery(sql);
      rs.next();
//         System.out.print("Count of Persons: " + id + "\n");
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("Goodbye!");
}
}
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class MySql {
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
          Class.forName("com.mysql.jdbc.Driver");
          java.sql.Connection c = DriverManager.getConnection("jdbc:mysql://localhost/Persona","root","root" );
          java.sql.Statement stmt = (Statement) c.createStatement();
//          String s =JOptionPane.showInputDialog("Select");
          
          
          JFrame parent = new JFrame();

          
          
          String sql;
          sql = "SELECT * FROM Person";
          ResultSet rs = stmt.executeQuery(sql);

           CalcFrame()
      	{	
      		setBounds(200, 150, 300, 300);
      		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      		setResizable(false);
      		setContentPane( new CalcPanel() );
      		setVisible(true);
      	}
          
//          while (rs.next())
//          {
//
//            int id = rs.getInt("id");
//            String firstName = rs.getString("first_name");
////            String lastName = rs.getString("last_name");
////            System.out.println(id);
////            System.out.println(firstName);
////            System.out.println(lastName);
//        	  
//              String multiLineMsg[] = { id + firstName +  "Hello,", "World"} ;
//              JOptionPane.showInputDialog(parent, multiLineMsg);
//          }
//          stmt.close();
          }
}
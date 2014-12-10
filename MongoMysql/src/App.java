import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
//        MySQLConnector connector = new MySQLConnector();
//        try {
//            Connection connection = connector.getConnection();
//            connection.close();
//            System.out.println("well done!");
//        } catch (SQLException e) {
//            System.out.println("not well done!");
//        }

        JFrame frame = new JFrame();
        frame.add(new Panel());
        frame.setSize(new Dimension(300, 200));
        frame.setMinimumSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

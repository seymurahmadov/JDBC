package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   private static Connection connection = null;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
         connection=   DriverManager.getConnection("jdbc:mysql://localhost:3306/project-jdbc","root","1999");
            System.out.println("Connection to DataBase has succesfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }

    public static void closeConnection(){
        try {
            connection.close();
            System.out.println("DataBase connection closed succesfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

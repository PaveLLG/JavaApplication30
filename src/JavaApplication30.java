import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class JavaApplication30 {
    private static final String DRIVER_NAME =  "com.mysql.cj.jdbc.Driver";
    private static final String CONN_STRING =  "jdbc:mysql://localhost:3306/?user=root&password=root";

    public static void main(String[] args) {

        //com.mysql.cj.jdbc.Driver
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements())
            System.out.println(drivers.nextElement());

        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found!");
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException e) {
            System.out.println("Cannot open connection! " + e.getMessage());
            return;
        }



    }
}

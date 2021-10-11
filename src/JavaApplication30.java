import java.sql.*;
import java.util.Enumeration;

public class JavaApplication30 {
    private static final String DRIVER_NAME =  "com.mysql.cj.jdbc.Driver";
    private static final String CONN_STRING =  "jdbc:mysql://localhost:3306/?user=root&password=root&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) {

        //com.mysql.cj.jdbc.Driver
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements())
            System.out.println(drivers.nextElement());

        //установка драйвера

        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found!");
            return;
        }

        //установка соединения

        Connection conn = null;

        try {
             conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException e) {
            System.out.println("Cannot open connection! " + e.getMessage());
            return;
        }

        //
        try{
            Statement st = conn.createStatement();
         //   st.executeUpdate("CREATE DATABASE db");
           st.executeUpdate("USE db");
         //  st.executeUpdate("CREATE TABLE persons (name varchar(32),age int(3))");
         //  st.executeUpdate("INSERT INTO persons (name, age) VALUES ('Name12',21)");
         ResultSet rs =   st.executeQuery("SELECT * FROM persons");
         while (rs.next()){
             System.out.println(rs.getString("name") +
                     " - " +
                     rs.getString("age")
             );
         }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }



    }
}

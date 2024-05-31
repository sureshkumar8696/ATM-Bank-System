package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Corrected the connection URL
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Suresht@k8696");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for better debugging
        }
    }


}

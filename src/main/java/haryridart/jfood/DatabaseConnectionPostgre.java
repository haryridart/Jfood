package haryridart.jfood;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This DatabaseConnectionPostgre Class is used to connect intellij to database postgres
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class DatabaseConnectionPostgre {
    protected static Connection connection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jfood", "postgres", "quatroespada");
            System.out.println("Opened Database Succesfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return c;
    }
}

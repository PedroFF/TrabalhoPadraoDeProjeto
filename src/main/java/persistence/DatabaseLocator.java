package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseLocator {

    private static DatabaseLocator instance = new DatabaseLocator();

    public static DatabaseLocator getInstance() {
        return instance;
    }

    private DatabaseLocator() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection conn
                = DriverManager.getConnection("jdbc:derby://localhost/design", "usuario", "senha");
        return conn;
    }
}

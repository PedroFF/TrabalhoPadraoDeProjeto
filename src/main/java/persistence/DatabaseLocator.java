package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseLocator {

    private static final DatabaseLocator instance = new DatabaseLocator();
    public static DatabaseLocator getInstance() {
        return instance;
    }

    private DatabaseLocator() {
    }

    public Connection getConnection() {
        try {
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            Connection conn
                    = DriverManager.getConnection("jdbc:postgresql://localhost:5432/padraoprojeto", "postgres", "12345");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

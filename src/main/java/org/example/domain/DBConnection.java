package org.example.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnection {

    private static Connection connection;

    private static Logger logger;

    static{
        logger = Logger.getLogger(Database.class.getName());

        String url = "jdbc:mysql://localhost:3306/ad";
        String user = "root";
        String password = "";
        try {
            connection = DriverManager.getConnection(url,user,password);
            logger.info("Successful connection to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}

package com.calderon.finance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Nathaniel on 3/24/2017.
 */
public class DbHelper {
    private static final String createURL = "jdbc:h2:smart-finance;create=true";
    public static final void createDB () throws SQLException{
        try (Connection conn = DriverManager.getConnection(createURL);
             Statement stmt = conn.createStatement()) {

            // Account entity
            stmt.executeUpdate("CREATE TABLE ACCOUNT ("
                    + "ID INTEGER PRIMARY KEY , "
                    + "name VARCHAR(255), "
                    + "num_acres DECIMAL)");

        }
    }
}

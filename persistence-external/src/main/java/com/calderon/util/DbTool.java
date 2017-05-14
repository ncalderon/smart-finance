package com.calderon.util;

import java.sql.*;

/**
 * Created by Nathaniel on 1/9/2017.
 */
public class DbTool {
    private Connection conn;
    public DbTool (String dbURL) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(dbURL);
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

        } catch (Exception e) {

        }

    }
}

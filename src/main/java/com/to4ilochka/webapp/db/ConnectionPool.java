package com.to4ilochka.webapp.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ConnectionPool instance;

    private ConnectionPool() {}

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        Context ctx;
        DataSource ds;
        Connection conn = null;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/web_app_db");
            conn = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

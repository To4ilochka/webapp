package com.to4ilochka.webapp.db.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {

    protected void close(Connection conn, Statement stmt) {
        close(stmt);
        close(conn);
    }

    protected void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
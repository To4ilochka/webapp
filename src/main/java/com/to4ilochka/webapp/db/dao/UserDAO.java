package com.to4ilochka.webapp.db.dao;

import com.to4ilochka.webapp.db.ConnectionPool;
import com.to4ilochka.webapp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO {

    private static UserDAO instance;

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public boolean insert(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConnectionPool.getInstance().getConnection();
            if (!isLoginExist(conn, user.getLogin())) {
                ps = conn.prepareStatement("INSERT INTO users (login, password) VALUES (?,?)");
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPassword());
                ps.executeUpdate();
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps);
        }
        return true;
    }

    public User getByLogin(String login) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = ConnectionPool.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT * FROM users WHERE login = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps);
        }
        return user;
    }

    public boolean isAdmin(String login) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isAdmin = false;
        try {
            conn = ConnectionPool.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT is_admin FROM users WHERE login = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();

            if (rs.next()) {
                isAdmin = rs.getBoolean("is_admin");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps);
        }
        return isAdmin;
    }

    public boolean isAdmin(User user) {
        return isAdmin(user.getLogin());
    }

    private boolean isLoginExist(Connection conn, String login) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE login = ?")) {
            ps.setString(1, login);
            return ps.executeQuery().next();
        }
    }
}

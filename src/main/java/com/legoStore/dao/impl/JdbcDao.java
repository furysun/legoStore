package com.legoStore.dao.impl;

import com.legoStore.config.propertyLoader.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public abstract class JdbcDao {
    private PropertyLoader propertyLoader = PropertyLoader.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(JdbcDao.class);

    public Connection createConnection() {
        try {
            // 1
            Class.forName(propertyLoader.getDriver());
            // 2
            return DriverManager.getConnection(propertyLoader.getDbUrl());
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Can not create connection" + e.getMessage());
            throw new RuntimeException("Can not create connection" + e.getMessage());
        }
    }

    public long executeAndGetKey(PreparedStatement preparedStatement) throws SQLException {
        long id;
        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating order failed, no rows affected.");
        }
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
                return id;
            } else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }
        }
    }
}

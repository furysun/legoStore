package com.legoStore.dao.impl;

import com.legoStore.config.propertyLoader.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class JdbsDao {
    private PropertyLoader propertyLoader = PropertyLoader.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(JdbsDao.class);

    public Connection creatConnection() {
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
}

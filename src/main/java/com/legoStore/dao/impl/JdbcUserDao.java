package com.legoStore.dao.impl;

import com.legoStore.config.propertyLoader.PropertyLoader;
import com.legoStore.controller.command.common.LoginCommand;
import com.legoStore.dao.UserDao;
import com.legoStore.dao.exception.UserNotFoundException;
import com.legoStore.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JdbcUserDao implements UserDao {
    private volatile static JdbcUserDao instance;
    private static final Logger logger = LoggerFactory.getLogger(JdbcUserDao.class);
    private PropertyLoader propertyLoader = PropertyLoader.getInstance();

    private JdbcUserDao() {
    }

    public static JdbcUserDao getInstance() {
        if (instance == null) {
            synchronized (JdbcUserDao.class) {
                if (instance == null) {
                    return new JdbcUserDao();
                }
            }
        }
        return instance;
    }

    public User findUserByLogin(String login) throws UserNotFoundException {

        User result = null;

        try {
            // 1
            Class.forName(propertyLoader.getDriver());
        } catch (ClassNotFoundException e) {
            logger.error("User not found:" + e.getMessage());
            throw new UserNotFoundException();
        }

            // 2
        try (Connection connection = DriverManager.getConnection(propertyLoader.getDbUrl())) {
            // 3
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS " +
                    "WHERE LOGIN=" + login);
            // 4
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = new User();
                result.setId(resultSet.getLong("ID"));
                result.setLogin(resultSet.getString("LOGIN"));
                result.setPassword(resultSet.getString("PASSWORD"));
            }

        } catch (SQLException e) {
            logger.error("User not found:" + e.getMessage());
            throw new UserNotFoundException();
        }

        return result;
    }
}

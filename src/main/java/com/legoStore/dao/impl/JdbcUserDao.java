package com.legoStore.dao.impl;

import com.legoStore.dao.UserDao;
import com.legoStore.dao.exception.UserNotFoundException;
import com.legoStore.domain.Role;
import com.legoStore.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDao extends JdbcDao implements UserDao {
    private volatile static JdbcUserDao instance;
    private static final Logger logger = LoggerFactory.getLogger(JdbcUserDao.class);

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
        // 2
        try (Connection connection = createConnection()) {
            // 3
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            // 4
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = extractUser(resultSet);
            }

        } catch (SQLException e) {
            logger.error("User not found:" + e.getMessage());
            throw new UserNotFoundException();
        }

        return result;
    }

    @Override
    public void createUser(User user) {
        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.CREATE_USER);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.execute();

        } catch (SQLException e) {
            logger.error("Can not create user:" + e.getMessage());
        }
    }

    private User extractUser(ResultSet resultSet) throws SQLException {

        User result = new User();
        result.setId(resultSet.getLong("ID"));
        result.setLogin(resultSet.getString("LOGIN"));
        result.setPassword(resultSet.getString("PASSWORD"));
        result.setRole(Role.valueOf(resultSet.getString("ROLE")));

        return result;
    }
}

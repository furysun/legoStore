package com.legoStore.dao.impl;

import com.legoStore.dao.exception.ItemNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JdbcBasketDao extends JdbcDao implements BasketDao {
    private volatile static JdbcBasketDao instance;
    private static final Logger logger = LoggerFactory.getLogger(JdbcBasketDao.class);


    private JdbcBasketDao() {
    }

    public static JdbcBasketDao getInstance() {
        if (instance == null) {
            synchronized (JdbcBasketDao.class) {
                if (instance == null) {
                    return new JdbcBasketDao();
                }
            }
        }
        return instance;
    }

    @Override
    public long createBasket() {
        long id;

        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.CREAT_BASKET,
                    Statement.RETURN_GENERATED_KEYS);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating basket failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating basket failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ItemNotFoundException();
        }

        return id;
    }
}

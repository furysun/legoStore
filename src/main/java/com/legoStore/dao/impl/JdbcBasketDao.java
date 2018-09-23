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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.CRETE_BASKET,
                    Statement.RETURN_GENERATED_KEYS);

            id = executeAndGetKey(preparedStatement);

        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ItemNotFoundException();
        }

        return id;
    }
}

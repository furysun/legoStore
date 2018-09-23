package com.legoStore.dao.impl;

import com.legoStore.dao.OrdersDao;
import com.legoStore.dao.exception.ItemNotFoundException;
import com.legoStore.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JdbcOrdersDao extends JdbcDao implements OrdersDao {

    private volatile static JdbcOrdersDao instance;

    private static final Logger logger = LoggerFactory.getLogger(JdbcOrdersDao.class);

    private JdbcOrdersDao() {
    }

    public static JdbcOrdersDao getInstance() {
        if (instance == null) {
            synchronized (JdbcOrdersDao.class) {
                if (instance == null) {
                    return new JdbcOrdersDao();
                }
            }
        }
        return instance;
    }

    @Override
    public long save(Order order) {
        long id;

        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.SAVE_ORDER, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, order.getAddress());
            preparedStatement.setBoolean(2, order.getCompleted());
            preparedStatement.setLong(3, order.getClientId());

            id = executeAndGetKey(preparedStatement);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ItemNotFoundException();
        }
        return id;
    }
}

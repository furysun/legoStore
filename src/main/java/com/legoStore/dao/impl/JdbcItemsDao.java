package com.legoStore.dao.impl;


import com.legoStore.dao.ItemsDao;
import com.legoStore.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcItemsDao extends JdbcDao implements ItemsDao {
    private volatile static JdbcItemsDao instance;

    private static final Logger logger = LoggerFactory.getLogger(JdbcItemsDao.class);


    private JdbcItemsDao() {
    }

    public static JdbcItemsDao getInstance() {
        if (instance == null) {
            synchronized (JdbcItemsDao.class) {
                if (instance == null) {
                    return new JdbcItemsDao();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Item> getAll() {
        logger.debug(" get all");

        List<Item> result = new ArrayList<>();

        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.GET_ALL_ITEMS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Item item = extractItem(resultSet);
                result.add(item);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return result;
    }

    private Item extractItem(ResultSet resultSet) throws SQLException {

        Item result = new Item();

        result.setId(resultSet.getInt("ID"));
        result.setName(resultSet.getString("NAME"));
        result.setPrice(resultSet.getInt("PRICE"));

        return result;
    }
}


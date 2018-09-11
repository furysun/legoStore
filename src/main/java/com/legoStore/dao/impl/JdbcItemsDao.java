package com.legoStore.dao.impl;


import com.legoStore.dao.ItemDao;
import com.legoStore.dao.exception.ItemNotFoundException;
import com.legoStore.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcItemsDao extends JdbcDao implements ItemDao {
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

    @Override
    public Item findById(long id) {
        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.GET_ITEM_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return extractItem(resultSet);
            } else throw new ItemNotFoundException();

        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ItemNotFoundException();
        }
    }

    @Override
    public void save(Item item) {

        try (Connection connection = createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.UPDATE_ITEM);

            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, item.getPrice());
            preparedStatement.setLong(3, item.getBasketId());
            preparedStatement.setLong(4, item.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ItemNotFoundException();
        }

    }

    private Item extractItem(ResultSet resultSet) throws SQLException {

        Item result = new Item();

        result.setId(resultSet.getInt("ID"));
        result.setName(resultSet.getString("NAME"));
        result.setPrice(resultSet.getInt("PRICE"));

        String basketId = resultSet.getString("BASKET_ID");

        if (basketId != null && !basketId.equals("")) {
            result.setBasketId(Long.parseLong(basketId));
        }

        String orderId = resultSet.getString("ORD_ID");
        if (orderId != null && !orderId.equals("")) {
            result.setOrderId(Long.parseLong(orderId));
        }

        return result;
    }
}


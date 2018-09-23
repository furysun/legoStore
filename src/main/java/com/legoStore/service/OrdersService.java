package com.legoStore.service;

import com.legoStore.dao.OrdersDao;
import com.legoStore.dao.impl.JdbcOrdersDao;
import com.legoStore.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrdersService {

    private static final Logger logger = LoggerFactory.getLogger(OrdersService.class);
    private volatile static OrdersService instance;

    private JdbcOrdersDao ordersService = JdbcOrdersDao.getInstance();
    private OrdersDao ordersDao = JdbcOrdersDao.getInstance();

    private OrdersService() {
    }

    public static OrdersService getInstance() {
        if (instance == null) {
            synchronized (OrdersService.class) {
                if (instance == null) {
                    return new OrdersService();
                }
            }
        }
        return instance;
    }
    public long save(Order order){
       return ordersDao.save(order);
    }
}

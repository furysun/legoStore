package com.legoStore.dao;

import com.legoStore.domain.Order;

public interface OrdersDao {
    long save(Order order);
}

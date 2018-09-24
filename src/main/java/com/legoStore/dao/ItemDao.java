package com.legoStore.dao;


import com.legoStore.domain.Item;

import java.util.List;

public interface ItemDao {
    List<Item> getAll();

    Item findById(long id);

    void save(Item item);

    List<Item> getAllByBasketId(long basketId);

    void addToOrder(long orderId, long basketId);
}
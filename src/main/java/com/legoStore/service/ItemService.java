package com.legoStore.service;

import com.legoStore.dao.ItemsDao;
import com.legoStore.dao.impl.JdbcItemsDao;
import com.legoStore.domain.Item;

import java.util.List;

public class ItemService {
    private volatile static ItemService instance;
    private ItemsDao userDao = JdbcItemsDao.getInstance();

    private ItemService() {
    }

    public static ItemService getInstance() {
        if (instance == null) {
            synchronized (ItemService.class) {
                if (instance == null) {
                    return new ItemService();
                }
            }
        }
        return instance;
    }

    public List<Item> getAll() {
        return userDao.getAll();
    }
}

package com.legoStore.dao;


import com.legoStore.domain.Item;

import java.util.List;

public interface ItemsDao {
    List<Item> getAll();
}
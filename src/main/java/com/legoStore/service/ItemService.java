package com.legoStore.service;

import com.legoStore.dao.ItemDao;
import com.legoStore.dao.impl.JdbcItemsDao;
import com.legoStore.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    private volatile static ItemService instance;

    private ItemDao itemDao = JdbcItemsDao.getInstance();

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
        return itemDao.getAll();
    }

    public void addItemToBasket(long itemId, long basketId) {
        Item item = itemDao.findById(itemId);
        item.setBasketId(basketId);

        logger.debug("ItemService method addItemToBasket");

        itemDao.save(item);
    }

    public List<Item> getAllByBasketId(long basketId) {
        return itemDao.getAllByBasketId(basketId);
    }

    public void addToOrder(long orderId, long basketId) {
        itemDao.addToOrder(orderId, basketId);
    }
}

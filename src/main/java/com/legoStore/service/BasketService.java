package com.legoStore.service;

import com.legoStore.dao.impl.BasketDao;
import com.legoStore.dao.impl.JdbcBasketDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketService {

    private static final Logger logger = LoggerFactory.getLogger(BasketService.class);

    private volatile static BasketService instance;
    private BasketDao basketDao = JdbcBasketDao.getInstance();

    private BasketService() {
    }

    public static BasketService getInstance() {
        if (instance == null) {
            synchronized (BasketService.class) {
                if (instance == null) {
                    return new BasketService();
                }
            }
        }
        return instance;
    }

    public long createBasket() {
        return basketDao.createBasket();
    }
}

package com.legoStore.service;

import com.legoStore.dao.UserDao;
import com.legoStore.dao.exception.UserNotFoundException;
import com.legoStore.dao.impl.JdbcUserDao;
import com.legoStore.domain.User;

public class UserService {

    private volatile static UserService instance;

    private UserDao userDao = JdbcUserDao.getInstance();

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    return new UserService();
                }
            }
        }

        return instance;
    }

    public User findUserByLogin(String login) throws UserNotFoundException {
        return userDao.findUserByLogin(login);
    }
}

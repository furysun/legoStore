package com.legoStore.dao;

import com.legoStore.dao.exception.UserNotFoundException;
import com.legoStore.domain.User;

public interface UserDao {
    User findUserByLogin(String login) throws UserNotFoundException;
    void createUser(User user);
}

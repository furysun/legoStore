package com.legoStore.dao.impl;

public class SqlQueries {
    public final static String FIND_USER_BY_LOGIN = "SELECT * FROM USERS " +
            "WHERE LOGIN = ?";

}

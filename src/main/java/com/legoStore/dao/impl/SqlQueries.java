package com.legoStore.dao.impl;

public class SqlQueries {
    public final static String FIND_USER_BY_LOGIN = "SELECT * FROM USERS " +
            "WHERE LOGIN = ?";
    public static final String CREATE_USER = "INSERT INTO USERS(NAME, LOGIN, PASSWORD, ROLE)" +
            "VALUES (?,?,?,'USER');\n";
}

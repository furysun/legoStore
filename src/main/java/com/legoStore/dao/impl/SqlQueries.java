package com.legoStore.dao.impl;

public class SqlQueries {
    public final static String FIND_USER_BY_LOGIN = "SELECT * FROM USERS " +
            "WHERE LOGIN = ?";
    public static final String CREATE_USER = "INSERT INTO USERS(NAME, LOGIN, PASSWORD, ROLE, BASKET_ID)" +
            "VALUES (?,?,?,'USER',?);\n";

    public final static String GET_ALL_ITEMS = "SELECT * FROM ITEMS";

    public final static String GET_ITEM_BY_ID = "select * from ITEMS where ID=?";

    public final static String UPDATE_ITEM  = "UPDATE ITEMS" +
            " SET NAME = ?, PRICE = ?, BASKET_ID = ?" +
            " WHERE ID = ?";
    public final static String CRETE_BASKET = "INSERT INTO BASKETS VALUES ();";

    public final static String GET_ITEM_BY_BASKETID = "select * from ITEMS where BASKET_ID = ?";

}

package com.legoStore.controller.command.user;

import com.legoStore.controller.Path;
import com.legoStore.controller.command.Command;
import com.legoStore.domain.Item;
import com.legoStore.domain.User;
import com.legoStore.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetItemsCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(GetItemsCommand.class);

    private ItemService itemService = ItemService.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = itemService.getAll();
        req.getSession().setAttribute("items", items);

        User user = (User) req.getSession().getAttribute("currentUser");

        req.getSession().setAttribute("currentBasketId", user.getBasketId());
        logger.debug("GetItemsCommand");


        int count = 0;

        for (Item item : items) {
            if (item.getBasketId() != null && item.getBasketId() == user.getBasketId()) {
                count++;
            }
        }
// 1 при регистрации создавать корзину юзеру 2) фильтровать айтымы не лежат ли они в чужой карзиние 3) рефактор
        req.getSession().setAttribute("countInCart", count);

        return Path.ITEMS_PAGE;
    }
}

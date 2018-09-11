package com.legoStore.controller.command.user;

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

import static com.legoStore.controller.Path.GET_ITEMS_COMMAND;

public class AddToCartCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(AddToCartCommand.class);
    private ItemService itemService = ItemService.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long itemId = Long.parseLong(req.getParameter("itemId"));
        logger.debug("Add To Cart Command: " + itemId);

        User user = (User) req.getSession().getAttribute("currentUser");
        long basketId = user.getBasketId();

        itemService.addItemToBasket(itemId, basketId);

        logger.debug("AddToCartCommand ");
        return GET_ITEMS_COMMAND;
    }
}

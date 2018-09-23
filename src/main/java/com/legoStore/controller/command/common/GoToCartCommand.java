package com.legoStore.controller.command.common;

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

public class GoToCartCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(GoToCartCommand.class);
    private ItemService itemService = ItemService.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");

        long basketId = user.getBasketId();

        List <Item> items = itemService.getAllByBasketId(basketId);

        req.getSession().setAttribute("items", items);

        return Path.CART_PAGE;
    }
}

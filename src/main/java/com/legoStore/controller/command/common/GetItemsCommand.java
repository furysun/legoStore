package com.legoStore.controller.command.common;

import com.legoStore.controller.Path;
import com.legoStore.controller.command.Command;
import com.legoStore.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetItemsCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(GetItemsCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item1 = new Item(1, "ty", 23);
        Item item2 = new Item(2, "oy", 23);
        Item item3 = new Item(3, "to", 23);
        Item item4 = new Item(4, "lol", 23);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        req.getSession().setAttribute("items", items);
        logger.debug("my items");

        return Path.ITEMS_PAGE;
    }
}

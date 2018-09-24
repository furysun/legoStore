package com.legoStore.controller.command.common;

import com.legoStore.controller.command.Command;
import com.legoStore.domain.Order;
import com.legoStore.domain.User;
import com.legoStore.service.ItemService;
import com.legoStore.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.legoStore.controller.Path.ORDER_CREATED;

public class CheckoutCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(CheckoutCommand.class);

    private OrdersService ordersService = OrdersService.getInstance();
    private ItemService itemService = ItemService.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        String address = req.getParameter("address");

        order.setAddress(address);
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        order.setClientId(currentUser.getId());

        long orderId = ordersService.save(order);
        long basketId = currentUser.getBasketId();
        itemService.addToOrder(orderId, basketId);

        return ORDER_CREATED;
    }
}

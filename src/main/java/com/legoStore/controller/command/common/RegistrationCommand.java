package com.legoStore.controller.command.common;

import com.legoStore.controller.Path;
import com.legoStore.controller.command.Command;
import com.legoStore.domain.User;
import com.legoStore.service.BasketService;
import com.legoStore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationCommand.class);

    private UserService userService = UserService.getInstance();
    private BasketService basketService = BasketService.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("RegistrationCommand");

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            req.getSession().setAttribute("registrationError", true);
            return Path.REGISTRATION_PAGE;
        }

        String name = req.getParameter("name");
        String login = req.getParameter("login");

        User user = new User();
        long basketId = basketService.createBasket();

        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setBasketId(basketId);

        userService.createUser(user);

        req.getSession().setAttribute("registrationError", false);
        return Path.LOGIN_PAGE;
    }
}

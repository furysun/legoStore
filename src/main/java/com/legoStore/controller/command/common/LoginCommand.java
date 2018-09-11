package com.legoStore.controller.command.common;

import com.legoStore.controller.Path;
import com.legoStore.controller.command.Command;
import com.legoStore.dao.exception.UserNotFoundException;
import com.legoStore.domain.Role;
import com.legoStore.domain.User;
import com.legoStore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(LoginCommand.class);

    private UserService userService = UserService.getInstance();

    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("execute");

        String login = req.getParameter("login");

        User user;

        try {
            user = userService.findUserByLogin(login);
        } catch (UserNotFoundException e) {
            req.getSession().setAttribute("loginError", true);
            return Path.LOGIN_PAGE;
        }

        String password = req.getParameter("password");
        if (!password.equals(user.getPassword())) {
            req.getSession().setAttribute("loginError", true);
            return Path.LOGIN_PAGE;
        }
        req.getSession().setAttribute("loginError", false);
        logger.debug("user name "+user.getName());

        req.getSession().setAttribute("currentUser", user);

        req.getSession().setAttribute("username",user.getName());

        if (user.getRole() == Role.USER) {
            return Path.GET_ITEMS_COMMAND;
        } else if (user.getRole() == Role.ADMIN) {
            return Path.HI_PAGE;
        }
        return null;
    }
}

package com.legoStore.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.legoStore.controller.command.Command;
import com.legoStore.controller.command.CommandContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Controller extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Controller process");

        String commandName = req.getParameter("command");

        logger.debug("got commandName from request: " + commandName);
        Command command = CommandContainer.getInstance().getCommand(commandName);

        logger.debug("retrieved command from command container. ");

        String result = command.execute(req, resp);

        if (result.endsWith(".jsp")) {
            logger.debug("redirect to " + result);
            resp.sendRedirect(result);
        } else {
            logger.debug("forward");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(Path.GET_ITEMS_COMMAND);
            requestDispatcher.forward(req,resp);
        }
    }
}

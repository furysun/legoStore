package com.legoStore.config;

import com.legoStore.controller.command.Command;
import com.legoStore.controller.command.CommandContainer;
import com.legoStore.controller.command.common.GoToHelloUserCommand;
import com.legoStore.controller.command.common.GoToLoginCommand;
import com.legoStore.controller.command.common.GoToRegistrationCommand;
import com.legoStore.controller.command.common.LoginCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

import static com.legoStore.controller.command.CommandName.*;


public class ContextListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("Context initialized:  ^-^ ");

        initializeCommandContainer();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void initializeCommandContainer() {
        logger.debug("Initialize Command Container");

        CommandContainer commandContainer = CommandContainer.getInstance();
        Map<String, Command> commandMap = new HashMap<String, Command>();

        commandMap.put(GO_TO_LOGIN.name(), new GoToLoginCommand());
        commandMap.put(GO_TO_REGISTRATION.name(), new GoToRegistrationCommand());
        commandMap.put(GO_TO_HELLO.name(), new GoToHelloUserCommand());
        commandMap.put(LOGIN.name(), new LoginCommand());

        commandContainer.setCommands(commandMap);
    }
}

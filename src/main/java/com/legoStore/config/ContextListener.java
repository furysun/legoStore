package com.legoStore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("Context initialized:  ^-^ ");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

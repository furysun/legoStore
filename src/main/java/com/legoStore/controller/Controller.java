package com.legoStore.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Controller extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("get");

        String action = req.getParameter("action");
        if(action.equals("GO_TO_LOGIN")){
            resp.sendRedirect("/jsp/login.jsp");
        } else if(action.equals("GO_TO_REGISTRATION")){
            resp.sendRedirect("/jsp/registration.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

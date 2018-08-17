package com.legoStore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    private static final Logger logger = LoggerFactory.getLogger(Filter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("Filter init ");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("Do filter");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}

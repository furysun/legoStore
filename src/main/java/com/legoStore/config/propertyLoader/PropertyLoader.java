package com.legoStore.config.propertyLoader;

import com.legoStore.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private volatile static PropertyLoader instance;

    private static final Logger logger = LoggerFactory.getLogger(PropertyLoader.class);

    private PropertyLoader() {
    }

    public static PropertyLoader getInstance() {
        if (instance == null) {
            synchronized (PropertyLoader.class) {
                if (instance == null) {
                    return new PropertyLoader();
                }
            }
        }
        return instance;
    }

    public String getDbUrl() {
        return readProperty("db.url");

    }

    public String getDriver() {
        return readProperty("db.driver");

    }

    private String readProperty(String key) {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("jdbc.properties");

        try {
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            logger.error("property driver not found");
            throw new PropertyNotFoundException();
        }
    }
}

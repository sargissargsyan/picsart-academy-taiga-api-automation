package io.taiga.utils;

import lombok.extern.java.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log
public class ConfigManager {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties;
    private static ConfigManager instance;

    private ConfigManager() {
        loadProperties();
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public void loadProperties() {
        log.info("Loading properties from file: " + CONFIG_FILE);
        properties = new Properties();
        try (InputStream inputStream  = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(inputStream);
            log.info("Properties loaded successfully");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + CONFIG_FILE, e);
        }
    }

    public String getProperty(String key) {
        String value = System.getProperty(key);
        if (value == null) {
            value = properties.getProperty(key);
        }
        log.info(key + " property value: " + value);
        return value;
    }

    public String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        return value != null ? value : defaultValue;
    }

    public int getIntProperty(String key) {
        String value = System.getProperty(key);
        if (value == null) {
            value = properties.getProperty(key);
        }
        log.info(key + " property value: " + value);
        return Integer.parseInt(value);
    }

    public int getIntProperty(String key, int defaultValue) {
        Integer value = getIntProperty(key);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public String getBaseUrl() {
        return getProperty("base.url", "http://localhost");
    }

    public String getSeleniumBrowser() {
        return getProperty("selenium.browser", "chrome");
    }

    public int getPort() {
        return getIntProperty("base.port", 9000);
    }

}

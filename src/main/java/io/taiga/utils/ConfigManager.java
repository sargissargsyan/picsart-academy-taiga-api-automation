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


    private void loadProperties() {
        log.info("Loading configuration from: " + CONFIG_FILE);
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (inputStream == null) {
                log.severe("Configuration file '" + CONFIG_FILE + "' not found in classpath");
                throw new RuntimeException("Configuration file '" + CONFIG_FILE + "' not found in classpath");
            }
            properties.load(inputStream);
            log.info("Configuration loaded successfully. Environment: " + getEnvironment());
        } catch (IOException e) {
            log.severe("Failed to load configuration file: " + CONFIG_FILE + ". Error: " + e.getMessage());
            throw new RuntimeException("Failed to load configuration file: " + CONFIG_FILE, e);
        }
    }

    public String getProperty(String key) {
        String value = System.getProperty(key);
        if (value == null) {
            value = properties.getProperty(key);
        }
        return value;
    }

    public String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        return value != null ? value : defaultValue;
    }

    public int getIntProperty(String key) {
        String value = getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found");
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Property '" + key + "' is not a valid integer: " + value, e);
        }
    }

    public int getIntProperty(String key, int defaultValue) {
        String value = getProperty(key);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public boolean getBooleanProperty(String key) {
        String value = getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found");
        }
        return Boolean.parseBoolean(value);
    }

    public boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = getProperty(key);
        if (value == null) {
            return defaultValue;
        }
        return Boolean.parseBoolean(value);
    }

    public String getBaseUrl() {
        return getProperty("base.url");
    }

    public int getBasePort() {
        return getIntProperty("base.port");
    }


    public String getEnvironment() {
        return getProperty("environment", "local");
    }
}
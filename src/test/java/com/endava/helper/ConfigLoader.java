package com.endava.helper;

import java.io.IOException;
import java.util.Properties;


public class ConfigLoader {
    private static final String PROPERTIES_FILENAME = "/com/endava/config.properties";
    private static Properties properties;

    private ConfigLoader() {
    }

    public static String getValueByKey(String key) {
        if (properties == null) {
            loadProperties();
        }
        return properties.get(key).toString();
    }

    private static Properties loadProperties() {
        try {
            properties = new Properties();
            properties.load(ConfigLoader.class.getResourceAsStream(PROPERTIES_FILENAME));
        } catch (IOException e) {
        }
        return properties;
    }

}



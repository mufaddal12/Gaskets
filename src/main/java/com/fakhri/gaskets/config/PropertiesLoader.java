package com.fakhri.gaskets.config;

import com.fakhri.gaskets.exceptions.ApplicationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static Properties properties;

    private PropertiesLoader() {}

    public static Properties loadProperties() {
        if(properties != null) {
            return properties;
        }
        try(InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
        return properties;
    }
}
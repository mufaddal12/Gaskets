package com.fakhri.gaskets.config;

import com.fakhri.gaskets.exceptions.ApplicationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static Properties properties;

    private PropertiesLoader() {}

    public static Properties loadProperties() {
        if(properties == null){
            properties = new Properties();
            InputStream inputStream = PropertiesLoader.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties");
            try {
                properties.load(inputStream);
                inputStream.close();
            } catch (IOException e) {
                throw new ApplicationException(e);
            }
        }
        return properties;
    }
}
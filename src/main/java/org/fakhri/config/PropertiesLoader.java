package org.fakhri.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static Properties properties;

    private PropertiesLoader() {}

    public static Properties loadProperties() throws IOException {
        if(properties == null){
            properties = new Properties();
            InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("application.properties");
            properties.load(inputStream);
            inputStream.close();
        }
        return properties;
    }
}
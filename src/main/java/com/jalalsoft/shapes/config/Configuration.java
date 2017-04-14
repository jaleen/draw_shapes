package com.jalalsoft.shapes.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jalal.deen on 13/04/2017.
 */
public class Configuration {
    private Properties properties = new Properties();

    private Configuration() throws IOException {


    }

    public static Configuration init(String propertyFileName) throws IOException {

        Configuration configuration = new Configuration();
        configuration.loadProperties(propertyFileName);
        return configuration;

    }

    private void loadProperties(String propertyFileName) throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);

        properties.load(inputStream);

    }

    public String getPropertyValue(String propertyName) {
        return properties.getProperty(propertyName);
    }
}

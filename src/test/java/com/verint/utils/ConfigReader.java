package com.verint.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /**
     * ConfigReader class handle the reading of the properties file and also
     * acts as the getter for the property
     */
    private Properties properties;

    public ConfigReader() {
        FileReader reader;
        String configPath = "src/test/resources/config/config.properties";

        try {
            reader = new FileReader(configPath);
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public int getTimeOut() {
        String time = properties.getProperty("timeOut");
        return Integer.parseInt(time);
    }
}

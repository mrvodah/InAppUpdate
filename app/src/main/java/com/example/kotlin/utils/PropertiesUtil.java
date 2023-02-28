package com.example.kotlin.utils;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public static final String CUSTOM_PROPERTIES = "custom.properties";

    private static PropertiesUtil instance;
    private Properties properties;

    public PropertiesUtil(Properties properties) {
        this.properties = properties;
    }

    public static synchronized PropertiesUtil instance(Context context) {
        if (instance == null) {
            instance = new PropertiesUtil(loadProperties(context));
        }
        return instance;
    }

    private static Properties loadProperties(Context context) {
        Properties properties = new Properties();
        try {
            InputStream inputStream;
            inputStream = context.getAssets().open("configuration.properties");
            properties.load(inputStream);
            try {
                Properties custom = new Properties();
                inputStream = context.openFileInput(CUSTOM_PROPERTIES);
                custom.load(inputStream);
                properties.putAll(custom);
            } catch (FileNotFoundException e) {
            }
        } catch (IOException e) {
        }
        return properties;
    }

    public Properties getProperties() {
        return properties;
    }

}

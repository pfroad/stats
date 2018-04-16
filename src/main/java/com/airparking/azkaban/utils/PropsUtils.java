package com.airparking.azkaban.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtils.class);
    private final static Properties properties = new Properties();
    private final static String DEFAULT_PROP_FILE = "application.properties";

    static {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        InputStream in = classLoader.getResourceAsStream(DEFAULT_PROP_FILE);

        assert in != null;

        try {
            properties.load(in);
        } catch (IOException e) {
            LOGGER.error("Load properties is failed.", e);
        }
    }

    public static String get(String key) {
        assert key != null;
        return properties.getProperty(key);
    }

    public static Integer getInt(String key, Integer defaultValue) {
        assert key != null;
        String val = properties.getProperty(key);
        return val == null ? defaultValue : Integer.parseInt(val);
    }

    public static Long getLong(String key, final Long defaultValue) {
        assert key != null;
        String val = properties.getProperty(key);
        return val == null ? defaultValue : Long.parseLong(val);
    }

    public static Boolean getBoolean(String key, final Boolean defaultValue) {
        assert key != null;
        String val = properties.getProperty(key);
        return val == null ? defaultValue : Boolean.parseBoolean(val);
    }

//    public static <T> T get(String key, Class<T> type) {
//        assert key != null;
//        return type.cast(properties.get(key));
//    }

    public static Properties resolveProps(String propFile) {
        assert propFile != null && !propFile.equals("");

        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        try {
            InputStream in = classLoader.getResourceAsStream(propFile);

            final Properties properties = new Properties();
            if (propFile.endsWith("yml")) {
//            Yaml yaml = new Yaml();
//            Iterable it = yaml.loadAll(in);
//            if (it != null) {
//                final Properties properties = new Properties();
//                it.forEach({
//                        properties.setProperty(it)
//                });
//            }
            } else {
                try {
                    properties.load(in);
                } catch (IOException e) {
                }
            }

            return properties;
        } catch (Exception e) {
            return null;
        }

    }
}

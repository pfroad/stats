package com.airparking.azkaban.utils;


import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtils {
    public static Properties resolveProps(String propFile) {
        assert propFile != null && !propFile.equals("");

        ClassLoader classLoader = PropsUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream(propFile);

        final Properties properties = new Properties();
        if (propFile.endsWith("yml")) {
            Yaml yaml = new Yaml();
            Iterable it = yaml.loadAll(in);
            if (it != null) {
//                final Properties properties = new Properties();
//                it.forEach({
//                        properties.setProperty(it)
//                });
            }
        } else {

            try {
                properties.load(in);
            } catch (IOException e) {
            }
        }

        return properties;
    }
}

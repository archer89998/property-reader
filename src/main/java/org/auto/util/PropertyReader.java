package org.auto.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {

    private static final String SRC = "src";
    private static final String MAIN = "main";
    private static final String RESOURCES = "resources";
    private static final String PROPERTIES = ".properties";

    private PropertyReader() {
    }

    public static Map<String, String> getDataFromPropertyFile(String fileName) {
        Properties properties = new Properties();
        String filePath = Paths.get("", SRC, MAIN, RESOURCES, fileName + PROPERTIES).toAbsolutePath().toString();

        try (InputStream inStream = new FileInputStream(filePath)) {
            properties.load(inStream);
        } catch (FileNotFoundException e) {
            throw new PropertiesControllerException("File not found '%s'", e, filePath);
        } catch (IOException e) {
            throw new PropertiesControllerException("Cannot load '%s'", e, filePath);
        }

        Map<String, String> dataFromPropertyFile = new HashMap<>();
        properties.stringPropertyNames().forEach(name -> dataFromPropertyFile.put(name, properties.getProperty(name)));

        return dataFromPropertyFile;
    }
}

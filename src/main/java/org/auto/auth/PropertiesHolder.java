package org.auto.auth;

import org.auto.util.PropertyReader;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PropertiesHolder {

    private static Map<String, String> properties = new HashMap<>();

    private PropertiesHolder() {
    }

    public static Map<String, String> getPropertiesByPrefix(String prefix) {
        if (properties.isEmpty()) {
            properties = PropertyReader.getDataFromPropertyFile(System.getProperty("propFile"));
        }
        return properties.keySet().stream().filter(key -> key.startsWith(prefix)).collect(Collectors.toMap(key -> key.replace(prefix + ".", ""), key -> properties.get(key)));
    }
}

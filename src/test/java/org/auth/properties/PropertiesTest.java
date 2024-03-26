package org.auth.properties;

import org.auto.auth.PropertiesHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class PropertiesTest {

    @Test
    void propertiesTest() {
        Map<String, String> properties = PropertiesHolder.getPropertiesByPrefix("selenide");
        Assertions.assertEquals(6, properties.size());
    }
}

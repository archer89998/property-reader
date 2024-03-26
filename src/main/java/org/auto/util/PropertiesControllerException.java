package org.auto.util;

import lombok.extern.slf4j.Slf4j;

/**
 * Provides throw and log PropertiesControllerException
 */
@Slf4j
class PropertiesControllerException extends RuntimeException {

    PropertiesControllerException(String message, Throwable e, String... args) {
        super(String.format(message, args), e);
        log.error(String.format(message, args));
    }
}

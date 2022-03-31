package com.example.cameltutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelTutorialApplication {

    private static final Logger logger
            = LoggerFactory.getLogger(CamelTutorialApplication.class);

    public void logLevelDisplay () {
        logger.error("Error message");
        logger.warn("Warning message");
        logger.info("Info message");
        logger.debug("Debug message");
        logger.trace("Trace message");
    }

    public static void main(String[] args) {
        SpringApplication.run(CamelTutorialApplication.class, args);
        logger.info("Example log from {}", CamelTutorialApplication.class.getSimpleName());
    }

}

package com.kang.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Resume project.
 */
@SpringBootApplication
public final class ResumeApplication {

    private ResumeApplication() {
        // Private constructor to prevent instantiation
    }

    /**
     * Main method to start the Spring Boot application.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(ResumeApplication.class, args);
    }

}

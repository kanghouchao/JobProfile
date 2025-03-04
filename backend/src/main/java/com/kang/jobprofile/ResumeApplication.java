package com.kang.jobprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author kanghouchao
 */
@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "com.kang.jobprofile")
public class ResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class, args);
    }

}

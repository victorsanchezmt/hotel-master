package com.usa.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.usa.project.model"})  // scan JPA entities
@SpringBootApplication
public class RoomRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomRentalApplication.class, args);
    }

}

package com.timetravel.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TravelApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TravelApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TravelApplication.class, args);
    }
}


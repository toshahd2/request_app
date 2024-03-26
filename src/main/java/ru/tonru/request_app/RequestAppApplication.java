package ru.tonru.request_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RequestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequestAppApplication.class, args);
    }

}

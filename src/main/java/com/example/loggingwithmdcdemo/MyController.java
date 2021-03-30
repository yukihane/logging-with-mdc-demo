package com.example.loggingwithmdcdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class MyController {

    @GetMapping
    String index() {
        log.error("MyController");

        throw new RuntimeException("Error occured.");
    }
}

package com.javaguides.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }
}

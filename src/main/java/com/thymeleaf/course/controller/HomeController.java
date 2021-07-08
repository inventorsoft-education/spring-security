package com.thymeleaf.course.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * endpoint for all users
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    @GetMapping
    public ResponseEntity<String> getHome() {
        return ResponseEntity.ok("Hello world!");
    }
}

package com.thymeleaf.course.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainController {
    @GetMapping
    public ResponseEntity<String> getMain() {
        return ResponseEntity.ok("Hello people!");

    }
}
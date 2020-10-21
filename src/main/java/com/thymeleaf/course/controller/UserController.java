package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api/users")
@AllArgsConstructor
public class UserController {

    final UserService userService;

    /* TODO entity shouldn't be send directly without advanced mapping. */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
     return ResponseEntity.ok(userService.getAll());
    }
}

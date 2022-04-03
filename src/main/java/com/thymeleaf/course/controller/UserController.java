package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dto.UserInfo;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
@AllArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserInfo>> getAllUsersAdmins() {
        return ResponseEntity.ok(userService.getAllAdmins());
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/bien")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> bienvenidos() {
        return ResponseEntity.ok("Bienvenido!");
    }
}



package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dictionary.Role;
import com.thymeleaf.course.domain.model.dto.UserDto;
import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
@AllArgsConstructor
public class UserController {

    final UserService userService;

    /**
     * endpoint for authenticated users
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * endpoint for authenticated users with role ADMIN
     */
    @GetMapping("/admins")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserDto>> getAllUsersAdmins() {
        return ResponseEntity.ok(userService.getAllAdmins());
    }

    /**
     * endpoint for authenticated users with role USER
     */
    @GetMapping("/meta")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> meta() {
        return ResponseEntity.ok("some info");
    }
}

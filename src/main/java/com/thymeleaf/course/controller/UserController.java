package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    final UserService userService;

}

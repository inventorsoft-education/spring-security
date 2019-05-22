package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping(value = "/signup")
    public ModelAndView getSignUpPage(ModelAndView model) {
        model.setViewName("signUp");
        model.addObject("user", new UserSignUpRequest());
        return model;
    }

    @PostMapping(value = "/signup")
    public String saveUser(@ModelAttribute UserSignUpRequest request) {
        userService.saveUser(request);
        return "index";
    }
}

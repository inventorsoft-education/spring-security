package com.thymeleaf.course.domain.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSignUpRequest {

    String firstName;
    String lastName;
    String email;
    String password;
    String confirmPassword;

}

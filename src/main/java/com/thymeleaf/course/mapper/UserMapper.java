package com.thymeleaf.course.mapper;

import com.thymeleaf.course.domain.model.dictionary.Role;
import com.thymeleaf.course.domain.model.dto.UserDto;
import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User mapUserRequest2User(UserSignUpRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return user;
    }

    public static UserDto mapUser2UserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}

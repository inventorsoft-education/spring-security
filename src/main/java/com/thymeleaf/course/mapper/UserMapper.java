package com.thymeleaf.course.mapper;

import com.thymeleaf.course.domain.model.dto.UserInfo;
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
        user.setType(request.getType());

        return user;
    }

    public static UserInfo mapUser2UserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(user.getFirstName());
        userInfo.setLastName(user.getLastName());
        userInfo.setEmail(user.getEmail());
        return userInfo;
    }
}

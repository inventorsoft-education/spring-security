package com.thymeleaf.course.domain.model.dto;

import com.thymeleaf.course.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static java.util.Collections.emptyList;

public class AuthUser extends User {
    public AuthUser(UUID id) {
        this.id = id;
    }

    @Getter
    @Setter
    private UUID id;
}
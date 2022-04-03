package com.thymeleaf.course.domain.service;

import com.google.common.collect.Lists;
import com.thymeleaf.course.domain.model.dictionary.Type;
import com.thymeleaf.course.domain.model.dto.UserInfo;
import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.repository.UserRepository;
import com.thymeleaf.course.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    final UserRepository userRepository;

    @Transactional
    public void saveUser(UserSignUpRequest request) {
        User user = UserMapper.mapUserRequest2User(request);
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<User> findByEmail(@NonNull String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<User> getByRole(Type type) {
        return getAll().stream()
                .filter(user -> user.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<UserInfo> getAllUsers() {
        return getByRole(Type.USER).stream()
                .map(UserMapper::mapUser2UserInfo)
                .collect(Collectors.toList());
    }

    public List<UserInfo> getAllAdmins() {
        return getByRole(Type.ADMIN).stream()
                .map(UserMapper::mapUser2UserInfo)
                .collect(Collectors.toList());
    }
}

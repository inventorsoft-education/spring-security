package com.thymeleaf.course;

import com.thymeleaf.course.domain.model.dictionary.Role;
import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * DB initializer for tests.
 */
@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DBInitializer {

    UserService userService;
    BCryptPasswordEncoder encoder;

    @PostConstruct
    @Transactional
    public void initDb() {
        UserSignUpRequest user1 = new UserSignUpRequest();
        user1.setEmail("firstuseremail@test.com");
        user1.setFirstName("first user");
        user1.setLastName("first user");
        user1.setRole(Role.USER);

        /* Use in a case when don't have encoder. */
//        user1.setPassword("user1Password");

        user1.setPassword(encoder.encode("user1Password"));

        UserSignUpRequest user2 = new UserSignUpRequest();
        user2.setEmail("seconduseremail@test.com");
        user2.setFirstName("second user");
        user2.setLastName("second user");
        user2.setRole(Role.USER);

        /* Use in a case when don't have encoder. */
//        user2.setPassword("user2Password");
        user2.setPassword(encoder.encode("user2Password"));

        UserSignUpRequest user3 = new UserSignUpRequest();
        user3.setEmail("thirduseremail@test.com");
        user3.setFirstName("third user");
        user3.setLastName("third user");
        user3.setRole(Role.ADMIN);

        /* Use in a case when don't have encoder. */
//        user3.setPassword("user3Password");
        user3.setPassword(encoder.encode("user3Password"));

        Arrays.asList(user1, user2, user3)
                .forEach(userService::saveUser);
    }
}

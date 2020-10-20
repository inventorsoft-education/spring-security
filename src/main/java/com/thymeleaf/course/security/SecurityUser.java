package com.thymeleaf.course.security;

import com.thymeleaf.course.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

/**
 * Simple adapter between application's user and spring security's
 * authentication principal. Instance of this class will be returned from
 * {@link Authentication#getPrincipal()}
 */
@Getter
@Setter
public class SecurityUser extends org.springframework.security.core.userdetails.User {

    private Long id;

    public SecurityUser(String username, Collection<? extends GrantedAuthority> authorities) {
        super(username, "", authorities);
    }

    public SecurityUser(final User user) {
        super(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );

        this.id = user.getId();
    }
}
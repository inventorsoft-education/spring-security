package com.thymeleaf.course.security;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

   UserDetailServiceImpl userDetailService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").authenticated()
                .anyRequest().authenticated().and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)

                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login-resource")
                .defaultSuccessUrl("/api/users", true)
                .failureUrl("/login.html?error=true")
                .successHandler(new DefaultAuthenticationSuccessHandler())

                .and()
                .logout()
                .addLogoutHandler(new SecurityContextLogoutHandler())
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")


                /* Configuration for stateless application */

//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilterBefore(new FilterChainProxy() /* There should be your custom filter*/, UsernamePasswordAuthenticationFilter.class);

                /* access denied */
                .and()
                .exceptionHandling().accessDeniedPage("/error.html")

                .and()
                .csrf().disable();
    }

    /* Authentication in memory */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("thymeleaf@test.com")
//                .password("{noop}thymeleaf")
//                .roles("USER");
//    }

    /* User detail service */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

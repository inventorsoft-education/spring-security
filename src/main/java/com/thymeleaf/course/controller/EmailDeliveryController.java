package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.dto.EmailDto;
import com.thymeleaf.course.service.EmailDeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@Slf4j
public class EmailDeliveryController {

    private final EmailDeliveryService emailDeliveryService;

    @GetMapping
    @PreAuthorize("hasAuthority('developers:read')")
    public List<EmailDto> getAllEmails() {
        log.info("getAllEmails");
        return emailDeliveryService.listEmails();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public EmailDto getEmailById(@PathVariable Integer id) {
        log.info("getEmail by id {}", id);
        return emailDeliveryService.getEmail(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public EmailDto createEmail(@RequestBody EmailDto emailDto) {
        log.info("createEmail with id {}", emailDto.getId());
        return emailDeliveryService.createEmail(emailDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public EmailDto updateEmail(@PathVariable Integer id, @RequestBody EmailDto emailDto) {
        log.info("updateEmail by id {}", id);
        return emailDeliveryService.updateEmail(id, emailDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteUser(@PathVariable Integer id) {
        log.info("deleteEmail by id {}", id);
        emailDeliveryService.deleteEmail(id);
    }

}

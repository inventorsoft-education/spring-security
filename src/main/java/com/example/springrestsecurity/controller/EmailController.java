package com.example.springrestsecurity.controller;


import com.example.springrestsecurity.domain.Email;
import com.example.springrestsecurity.domain.dto.EmailDto;
import com.example.springrestsecurity.domain.mapper.EmailMapper;
import com.example.springrestsecurity.service.EmailService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor

public class EmailController {

    private final EmailService emailService;
    private final EmailMapper emailMapper;


    @GetMapping
    @PreAuthorize("hasAuthority('developers:read')")
    public List<EmailDto> getAllPendingEmailDeliveries() {
        return emailService.pendingEmailDeliveries().stream()
                .map(emailMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('developers:write')")
    public Email addNewEmailDelivery(@Valid @RequestBody EmailDto emailDto) {
        return emailService.createEmailDelivery(emailMapper.toEntity(emailDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public EmailDto updateDeliveryDate(@PathVariable Long id, @Valid @RequestBody EmailDto emailDto) {
        return emailService.updateDeliveryDate(id, emailDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('developers:write')")
    public void removePendingEmail(@PathVariable Long id) {
        emailService.removePendingEmail(id);
    }
}

package com.thymeleaf.course.service.impl;

import com.thymeleaf.course.domain.dto.EmailDto;
import com.thymeleaf.course.domain.entity.Email;
import com.thymeleaf.course.domain.mapper.EmailMapper;
import com.thymeleaf.course.exception.EmailNotFoundException;
import com.thymeleaf.course.repository.EmailRepository;
import com.thymeleaf.course.service.EmailDeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailDeliveryServiceImpl implements EmailDeliveryService {

    private final EmailRepository emailRepository;

    @Override
    public EmailDto getEmail(Integer id) {
        log.info("Finding email by {} id...", id);
        Email email = emailRepository.findById(id)
                .orElseThrow(EmailNotFoundException::new);
        log.info("Email with {} id is found", id);
        return EmailMapper.INSTANCE.mapModelToDto(email);
    }

    @Override
    public List<EmailDto> listEmails() {
        log.info("Get all emails");
        List<Email> emails = emailRepository.findAll();
        return EmailMapper.INSTANCE.mapListOfEmailToListOfDto(emails);
    }

    @Override
    public EmailDto createEmail(EmailDto emailDto) {
        log.info("Creating email with {} id...", emailDto.getId());
        Email email = EmailMapper.INSTANCE.mapDtoToModel(emailDto);
        email = emailRepository.save(email);
        log.info("Email with id {} successfully created", email.getId());
        return EmailMapper.INSTANCE.mapModelToDto(email);
    }

    @Override
    @Transactional
    public EmailDto updateEmail(Integer id, EmailDto emailDto) {
        log.info("Updating email with {} id...", id);
        Email persistedEmail = emailRepository.findById(id)
                .orElseThrow(EmailNotFoundException::new);
        EmailMapper.INSTANCE.updateEmailFromDto(persistedEmail, emailDto);
        Email storedEmail = emailRepository.save(persistedEmail);
        log.info("Email with id {} successfully updated", storedEmail.getId());
        return EmailMapper.INSTANCE.mapModelToDto(persistedEmail);
    }

    @Override
    public void deleteEmail(Integer id) {
        emailRepository.deleteById(id);
        log.info("Email with id {} was deleted", id);
    }

}

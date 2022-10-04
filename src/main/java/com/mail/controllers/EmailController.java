package com.mail.controllers;

import com.mail.dao.MessagesDao;
import com.mail.entities.TextMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/messages")
public class EmailController {

    MessagesDao mDao;

    @Autowired
    public EmailController(MessagesDao mDao) {
        this.mDao = mDao;
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('read')")
    public List<TextMessage> getMessages() {
        return mDao.readMessages();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read')")
    public TextMessage getById(@PathVariable Integer id) {
        return mDao.readMessage(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('write')")
    public Integer create(@RequestBody @Valid TextMessage textMessage) {
        return mDao.addMessage(textMessage);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('write')")
    public TextMessage updateMessage(@PathVariable Integer id, @RequestBody TextMessage textMessage) {
        return mDao.update(id, textMessage);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        mDao.deleteMessage(id);
    }
}

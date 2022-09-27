package mail.lemeshev.server.controller;

import lombok.AllArgsConstructor;
import mail.lemeshev.server.model.Message;
import mail.lemeshev.server.model.Permission;
import mail.lemeshev.server.service.MessageService;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
@AllArgsConstructor
public class MessageController {

    private MessageService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('can:write')")
    public Message addMessage(@RequestBody Message message) {
        return service.saveMessage(message);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('can:read')")
    public List<Message> findAllMessages() {
        return service.getMessages();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('can:write')")
    public Message findMessageById(@PathVariable Integer id) {
        return service.getMessageById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('can:write')")
    public Message updateMessage(@PathVariable Integer id, @RequestBody  Message message) {
        return service.updateMessage(id, message);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('can:delete')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable Integer id) {
        service.deleteMessage(id);
    }
}

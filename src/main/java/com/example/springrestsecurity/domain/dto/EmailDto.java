package com.example.springrestsecurity.domain.dto;


import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class EmailDto {
    @Email
    private String recipientName;

    @NotBlank
    private String emailSubject;

    @NotBlank
    private String emailBody;

    @NotNull
    private LocalDateTime deliveryDate;

    @NotNull
    private Boolean isSent = false;
}

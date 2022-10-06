package com.thymeleaf.course.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDto {

    private Integer id;
    private String sender;
    private String receiver;
    private String theme;
    private String content;
    private Boolean sent;
    private LocalDateTime date;

}

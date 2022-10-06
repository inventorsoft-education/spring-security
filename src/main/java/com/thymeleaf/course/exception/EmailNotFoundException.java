package com.thymeleaf.course.exception;

public class EmailNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Email is not found!";

    public EmailNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}

package ru.palekov.linkshortener.exception;

public class PageNotFoundException extends LinkShortenerException {
    public PageNotFoundException(String message) {
        super(message);
    }
}

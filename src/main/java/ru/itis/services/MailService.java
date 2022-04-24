package ru.itis.services;

import ru.itis.dto.MailDto;

public interface MailService {
    void send(String emailTo, String subject, String message);

    void send(MailDto mailDto);
}

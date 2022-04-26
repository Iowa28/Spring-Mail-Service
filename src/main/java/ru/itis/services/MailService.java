package ru.itis.services;

import ru.itis.dto.MailDto;
import ru.itis.models.Mail;

import java.util.List;

public interface MailService {
    void send(MailDto mailDto);

    List<MailDto> getBasketMails();
}

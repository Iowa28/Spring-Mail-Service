package ru.itis.mappers;

import ru.itis.dto.MailDto;
import ru.itis.models.Mail;

import java.util.List;
import java.util.stream.Collectors;

public class MailMapper {

    public static Mail convert(MailDto mailDto) {
        return Mail.builder()
                .receiver(mailDto.getEmailTo())
                .subject(mailDto.getSubject())
                .text(mailDto.getText())
                .build();
    }

    public static MailDto convert(Mail mail) {
        return MailDto.builder()
                .emailTo(mail.getReceiver())
                .subject(mail.getSubject())
                .text(mail.getText())
                .build();
    }

    public static List<MailDto> convert(List<Mail> mails) {
        return mails.stream().map(MailMapper::convert).collect(Collectors.toList());
    }
}

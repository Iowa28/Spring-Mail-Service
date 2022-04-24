package ru.itis.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dto.MailDto;
import ru.itis.services.MailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mails")
public class MailController {

    private final MailService mailService;

    @PostMapping
    public ResponseEntity<MailDto> sendEmail(@RequestBody MailDto mailDto) {
        mailService.send(mailDto);
        return ResponseEntity.ok(mailDto);
    }
}

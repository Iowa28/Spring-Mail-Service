package ru.itis.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.MailDto;
import ru.itis.services.MailService;

import java.util.List;

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

    @GetMapping("/basket")
    public ResponseEntity<List<MailDto>> getBasketMails() {
        return ResponseEntity.ok(mailService.getBasketMails());
    }
}

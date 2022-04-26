package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.itis.dto.MailDto;
import ru.itis.repositories.BasketRedisRepository;

import java.util.ArrayList;
import java.util.List;

import static ru.itis.mappers.MailMapper.convert;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private UsersService usersService;

    @Autowired
    private BasketRedisRepository basketRedisRepository;

    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String username;

    @Override
    public void send(MailDto mailDto) {
        if (usersService.hasUserWithEmail(mailDto.getEmailTo())) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(username);
            mailMessage.setTo(mailDto.getEmailTo());
            mailMessage.setSubject(mailDto.getSubject());
            mailMessage.setText(mailDto.getText());

            mailSender.send(mailMessage);
        } else {
            System.err.println("Такого пользовател в базе нет!");
            addMailToBasket(mailDto);
        }
    }

    private void addMailToBasket(MailDto mailDto) {
        basketRedisRepository.save(convert(mailDto));
    }

    @Override
    public List<MailDto> getBasketMails() {
        List<MailDto> mails = new ArrayList<>();
        basketRedisRepository.findAll().forEach(mail -> mails.add(convert(mail)));
        return mails;
    }
}

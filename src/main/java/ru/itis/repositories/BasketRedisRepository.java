package ru.itis.repositories;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import ru.itis.models.Mail;

public interface BasketRedisRepository extends KeyValueRepository<Mail, Long> {
}

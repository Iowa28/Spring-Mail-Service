package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.UserDto;
import ru.itis.repositories.UsersRepository;

import java.util.List;

import static ru.itis.mappers.UserMapper.*;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAll() {
        return convert(usersRepository.findAll());
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        usersRepository.save(convert(userDto));
        return userDto;
    }
}

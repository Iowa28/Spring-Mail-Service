package ru.itis.services;

import ru.itis.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAll();

    UserDto addUser(UserDto user);
}

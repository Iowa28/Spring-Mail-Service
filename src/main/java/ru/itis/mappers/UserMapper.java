package ru.itis.mappers;

import ru.itis.dto.UserDto;
import ru.itis.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User convert(UserDto user) {
        return User.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }

    public static UserDto convert(User user) {
        return UserDto.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }

    public static List<UserDto> convert(List<User> users) {
        return users.stream().map(UserMapper::convert).collect(Collectors.toList());
    }
}

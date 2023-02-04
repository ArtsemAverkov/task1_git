package ru.clevertec.git.service;

import org.springframework.data.domain.Pageable;
import ru.clevertec.git.dto.UserDto;
import ru.clevertec.git.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    long create(UserDto userDto);
    User read (long id);
    boolean update(User user, Long id);
    boolean delete (Long id);
    List<User> readAll (Pageable pageable);
    Optional<User> findByUserName(UserDto user);
}

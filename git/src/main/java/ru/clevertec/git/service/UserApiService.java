package ru.clevertec.git.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.clevertec.git.dto.UserDto;
import ru.clevertec.git.entity.Role;
import ru.clevertec.git.entity.User;
import ru.clevertec.git.repository.UserRepository;

import java.util.*;

@Service
public record UserApiService (UserRepository userRepository) implements UserService {
    @Override
    public long create(UserDto userDto) {
        User builder = builder(userDto);
        return userRepository.save(builder).getId();
    }

    @Override
    public User read(long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public boolean update(User user, Long id) {
        User read = read(id);
        if (Objects.nonNull(read)) {
            user.setId(id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        User read = read(id);
        if(Objects.nonNull(read)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> readAll(Pageable pageable) {
        return userRepository.findAll(pageable).toList();
    }

    @Override
    public Optional<User> findByUserName(UserDto user) {
        User byUserName = userRepository.findByUserName(user.getUserName());
        Optional<User> userName = Optional.ofNullable(byUserName);
        return userName;
    }

    private User builder (UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .mail(userDto.getMail())
                .password(userDto.getPassword())
                .roles(Collections.singleton(Role.USER))
                .build();
    }
}

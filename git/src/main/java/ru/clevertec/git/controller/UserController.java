package ru.clevertec.git.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.git.dto.UserDto;
import ru.clevertec.git.entity.User;
import ru.clevertec.git.service.UserService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/admin")
public record UserController(UserService userService){

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody @Valid UserDto user) {
        return userService.create(user);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public User read(@PathVariable Long id){
        return userService.read(id);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean updateDiscount(@PathVariable Long id, @RequestBody @Valid User user) {
        return userService.update(user, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable Long id) {
        return userService.delete(id);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> read(@PageableDefault(page = 0)
                                       @SortDefault(sort = "name") Pageable pageable) {
        return userService.readAll(pageable);
    }
}

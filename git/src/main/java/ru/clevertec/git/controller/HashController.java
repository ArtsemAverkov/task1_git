package ru.clevertec.git.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.git.entity.Hash;
import ru.clevertec.git.hashGenerator.HashMD5I;
import ru.clevertec.git.service.hash.HashService;

@Slf4j
@RestController
@RequestMapping("/hashGenerator")
public record HashController (HashService hashService,
                              HashMD5I hashMD5I){

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Long createHash(@RequestBody @Valid String hash) {
        String generator = hashMD5I.generator(hash);
        return hashService.create(generator);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Hash get (@PathVariable Long id) {
        return hashService.read(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteHash(@PathVariable Long id) {
        return hashService.delete(id);
    }
}

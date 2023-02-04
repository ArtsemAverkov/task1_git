package ru.clevertec.git.service.hash;


import ru.clevertec.git.entity.Hash;

public interface HashService {
    long create(String hash);
    Hash read (long id);
    boolean delete (Long id);


}

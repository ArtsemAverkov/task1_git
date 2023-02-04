package ru.clevertec.git.service.hash;

import org.springframework.stereotype.Service;
import ru.clevertec.git.entity.Hash;
import ru.clevertec.git.repository.hash.HashRepository;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public record HashApiService(HashRepository hashRepository) implements HashService{


    @Override
    public long create(String hash) {
        Hash build = build(hash);
        return hashRepository.save(build).getId();
    }

    @Override
    public Hash read(long id)  {
        return hashRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public boolean delete(Long id) {
        Hash read = read(id);
        if (Objects.nonNull(read)){
            hashRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Hash build(String hash){
        return Hash.builder()
                .hash(hash)
                .build();
    }
}

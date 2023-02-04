package ru.clevertec.git.repository.hash;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.git.entity.Hash;

public interface HashRepository extends JpaRepository<Hash, Long> {
}

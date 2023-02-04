package ru.clevertec.git.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.git.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}

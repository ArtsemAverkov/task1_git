package ru.clevertec.git.dto;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String password;
    @Transient
    private String passwordConfirm;
    private String mail;
    private String userName;
}

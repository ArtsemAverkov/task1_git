package ru.clevertec.git.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Hash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hash;
}

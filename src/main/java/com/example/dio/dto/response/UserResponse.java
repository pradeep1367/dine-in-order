package com.example.dio.dto.response;

import com.example.dio.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {

    private long userId;
    private String userName;
    private UserRole userRole;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}

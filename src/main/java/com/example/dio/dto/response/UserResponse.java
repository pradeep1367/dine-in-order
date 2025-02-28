package com.example.dio.dto.response;

import com.example.dio.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserResponse {

    private long userId;
    private String userName;
    private UserRole userRole;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}

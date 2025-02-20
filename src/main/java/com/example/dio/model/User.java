package com.example.dio.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
    private String username;
    private String email;
    private String password;
    private int phoneNo;
    private LocalDate createdAt;
    private LocalDate lastModifyDate;
    private String userRole;
}
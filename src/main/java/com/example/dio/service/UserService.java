package com.example.dio.service;

import com.example.dio.model.User;
import com.example.dio.util.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public User registerUser(User user);
}

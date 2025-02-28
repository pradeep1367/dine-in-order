package com.example.dio.service;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import com.example.dio.util.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public UserResponse registerUser(RegistrationRequest user);
    public UserResponse findUserById(long userId);
    public UserResponse updateUserById(long userId, UserRequest user);
}

package com.example.dio.service.impl;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.UserMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  final UserMapper userMapper;

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest){
        User user= this.createUserByRole(registrationRequest.getUserRole());
        userMapper.mapToUserEntity(registrationRequest,user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse findUserById(long userId){
        User user= userRepository.findById(userId)
                .orElseThrow(() ->new UserNotFoundByIdException("user not found by id"));
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse updateUserById(long userId, UserRequest userRequest) {
        User existingUser=userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException(" failed to updated / User not found"));
        userMapper.mapToUserEntity(userRequest,existingUser);
        userRepository.save(existingUser);
        return userMapper.mapToUserResponse(existingUser);
    }


    private User createUserByRole(UserRole  role)
    {
        User user;

        switch (role){
            case ADMIN -> user=new Admin();
            case STAFF-> user = new Staff();
            default -> throw new RuntimeException("Failed to register");
        }
        return user;
    }
}
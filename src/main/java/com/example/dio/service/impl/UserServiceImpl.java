package com.example.dio.service.impl;

import com.example.dio.enums.UserRole;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.dio.enums.UserRole.ADMIN;
import static com.example.dio.enums.UserRole.STAFF;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(User user){

        User user2= this.createUserByRole(user.getUserRole());
        this.mapToNewUser(user,user2);
        return userRepository.save(user2);
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

    private  void mapToNewUser(User user, User user2)
    {
        user2.setUserName(user.getUserName());
        user2.setUserRole(user.getUserRole());
        user2.setEmail(user.getEmail());
        user2.setPhoneNo(user.getPhoneNo());
        user2.setPassword(user.getPassword());
    }
}
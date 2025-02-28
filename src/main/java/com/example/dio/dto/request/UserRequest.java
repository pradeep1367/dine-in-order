package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String userName;
    private String email;
    private String phoneNo;
}

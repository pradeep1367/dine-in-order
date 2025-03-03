package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

    //@NotEmpty--for both
    @NotBlank(message = "username can not be blank")
    @NotNull(message = "Username can not be empty")
    private String userName;

    @NotBlank(message = "email can not be blank")
    @NotNull(message = "email can not empty")
    private String email;

    private String password;
    private String phoneNo;
    private UserRole userRole;

}
